package com.bit.model;
/**
 * -Connection Pool
 * Ŀ�ؼ� ��ü�� ���α׷��� ����� ������ �����Ǵ� JDBC ���α׷����� �������� �����ϱ� ����
 * �� ���ø����̼��� ���񽺵Ǳ� ���� �� �������� �̸� �����Ͽ� �غ��� ����, �ʿ��� Ŀ�ؼ��� ����Ѵ�.
 * 
 * -DataSource
 * Ŀ�ؼ� Ǯ�� Ŀ�ؼ��� �����ϱ� ���� ��ü
 * Ŀ�ؼ��� ȹ��, �ݳ� ���� �۾��� �Ѵ�.
 * JNDI Server�� ���ؼ� �̿��Ѵ�.
 * lookup�� ���ؼ� DataSource ��ü ȹ�� 
 * 	> DataSource�� getConnection�� ���� Ŀ�ؼ�Ǯ���� free������ Ŀ�ؼ�Ǯ ȹ��
 * 	> ȹ���� Ŀ�ؼ� ��ü�� ���� dbms ����
 * 	> ������ Ŀ�ؼ�Ǯ�� Ŀ�ؼ� �ݳ� 
 * 
 * -JNDI(Java Naming and Directory Interface)
 * ���͸� ���񽺿��� �����ϴ� ������ �� ��ü�� �߰�(discover)�ϰ� ����(lookup)�ϱ� ���� �ڹ� api
 * �ڹ� ���ø����̼��� �ܺ� ���͸� ���񽺿� ����
 * �ڹ� ���ø��� ȣ���� �� �����̳ʰ� �����ϴ� ���������� ����
 * 
 * https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html ���� �ɼ��� ���� Servers�� tomcat�� context.xml �� �߰���ų��
 * Servers�� context.xml�� �ش� ������ �־��� ������ ȯ���� �޶����� �ȵ� > ���Ŀ� �����ӿ�ũ�� �̿��ؼ��� ����
 * */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Guest02Dao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DataSource source;	
	
	//�ݺ��Ǵ� connection�� �����ڸ� ���� �ذ�
	public Guest02Dao(){
		try {
			//Ŀ�ؼ� Ǯ�� �����ϱ� ���� JNDI�� ����ؾ��Ѵ�. JNDI�� �������� �����ϴ� ���ҽ� ���� ��ü�� ��ȯ�Ѵ�.
			//JNDI ���� ��Ȱ�� �ϴ� ��ü�� ����, ���ҽ��� ���ÿ� �ֱ� ������ InitialContext�� �����ϸ� �ȴ�.
			InitialContext ic = new InitialContext();	
			
			// lookup�� ���ҽ��� ã���� Object��ü�� ��ȯ ���ش�.
			// ���ڷ� ã������ ���ҽ��� ��ϵ� �̸��� �����Ѵ�.
			// java:/comp/env �� WAS�� ��Ĺ���� ���ҽ��� �����ϴ� ���� ���͸�
			// jdbc/oracle�� ã������ ���ҽ��� �̸�
			this.source = (DataSource)ic.lookup("java:/comp/env/jdbc/oracle");//context.xml �� �ִ� Resource ���� ������ name���� lookup
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Guest02Dto> getList(){
		ArrayList<Guest02Dto> list = new ArrayList<Guest02Dto>();
		String sql = "SELECT g.num,g.sub,g.pay,u.name as uname";
				sql+= " FROM user02 u, guest02 g WHERE u.num=g.unum ORDER BY g.num DESC";
		
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Guest02Dto bean = new Guest02Dto();
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				bean.setName(rs.getString("uname"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();	//maxidle ���� Ŭ�� ��ȯ �ȴ�.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	public void insert(String sub, int unum, int pay) {
		String sql ="INSERT INTO guest02 VALUES(guest02_seq.nextval,?,?,SYSDATE,?)";
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setInt(2, unum);
			pstmt.setInt(3, pay);
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}


	public Guest02Dto detail(int num) {
		Guest02Dto bean = new Guest02Dto();
		String sql = "SELECT num,sub,unum,(SELECT name FROM user02 WHERE num = unum) as name,pay FROM guest02 WHERE num =?";
		
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				bean.setUnum(rs.getInt("unum"));
				bean.setName(rs.getString("name"));
				bean.setPay(rs.getInt("pay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return bean;
	}

}
