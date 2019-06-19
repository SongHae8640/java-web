package com.bit.model;

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
	
	DataSource source;	//�������̽��� ��������(ioc) �ڿ� ���������� ���� �� ��
	//������ Resource �� ������ ������ connection ��ü�� �غ��� �� ��ü�� war���� ������ connection�� ����
	//
	
	////// Context�� �������� ã�ƺ��� ***
	//Servlet�� ��ӹ��� ��ü�� getServletContext�� ���ؼ� context�� ������ �� ������ dao�� �ƴϱ� ������ 
	//
	
	
	//�ݺ��Ǵ� connection�� �����ڸ� ���� �ذ�
	public Guest02Dao(){
		try {
			InitialContext init = new InitialContext();
			 Context context = (Context)init.lookup("java:/comp/env");
			 this.source = (DataSource) context.lookup("jdbc/oracle");	//context.xml �� �ִ� Resourc ���� ������ name���� lookup

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Guest02Dto> getList(){
		ArrayList<Guest02Dto> list = new ArrayList<Guest02Dto>();
		String sql = "SELECT g.num,g.sub,g.pay,u.name as uname";
				sql+= " FROM user02 u, guest02 g WHERE u.num=g.unum ORDER BY g.num DESC";
	
		
		//connection pool
		// 1.���������� ��� ������ ������ ���� ���� �ƴ϶�
		// ������ ���� �ؼ� �� ����� ������ ������ �׶� ����
		// 2. �����Ҷ� ���� �����ϰ� ���� �ϴ� ���� �ƴ϶� ���� ��ü�� ����� ���� �̿� ���� �ϰ�		
		//https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html ���� �ɼ��� ���� Servers�� tomcat�� context.xml �� �߰���ų��
		//Servers�� context.xml�� �ش� ������ �־��� ������ ȯ���� �޶����� �ȵ� > ���Ŀ� �����ӿ�ũ�� �̿��ؼ��� ����
		// ��� �䱸������ env���� idle�� ���� ������ ��Ѱ� 
		
				
//		try {
//			InitialContext init = new InitialContext();
//			 Context context = (Context)init.lookup("java:/comp/env");
//			 source = (DataSource) context.lookup("jdbc/oracle");	//context.xml �� �ִ� Resourc ���� ������ name���� lookup
//
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();	//maxidle ���� Ŭ�� ��ȯ �ɰ� ��
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}


	public void insert(String sub, int unum, int pay) {
		String sql ="INSERT INTO guest02 VALUES(guest02_seq.nextval,?,?,SYSDATE,?)";
		
		source = null;
		
//		//getList�ʹ� �ٸ� ������� �غ���.
//		try {
//			InitialContext init = new InitialContext();
//			source = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");	//�ѹ��� lookup�ϱ�
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setInt(2, unum);
			pstmt.setInt(3, pay);
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
