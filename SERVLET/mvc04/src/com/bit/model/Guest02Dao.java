package com.bit.model;
/**
 * -Connection Pool
 * 커넥션 객체를 프로그램이 실행될 때마다 생성되는 JDBC 프로그래밍의 문제점을 개선하기 위해
 * 웹 애플리케이션이 서비스되기 전에 웹 서버에서 미리 생성하여 준비한 다음, 필요한 커넥션을 사용한다.
 * 
 * -DataSource
 * 커넥션 풀의 커넥션을 관리하기 위한 객체
 * 커넥션의 획득, 반납 등의 작업을 한다.
 * JNDI Server를 통해서 이용한다.
 * lookup을 통해서 DataSource 객체 획득 
 * 	> DataSource의 getConnection을 통해 커넥션풀에서 free상태의 커넥션풀 획득
 * 	> 획득한 커넥션 객체를 통해 dbms 수행
 * 	> 끝나면 커넥션풀에 커넥션 반납 
 * 
 * -JNDI(Java Naming and Directory Interface)
 * 디렉터리 서비스에서 제공하는 데이터 및 객체를 발견(discover)하고 참고(lookup)하기 위한 자바 api
 * 자바 애플리케이션을 외부 디렉터리 서비스에 연결
 * 자바 애플릿이 호스팅 웹 컨테이너가 제공하는 구성정보를 참고
 * 
 * https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html 에서 옵션을 보고 Servers의 tomcat에 context.xml 에 추가시킬것
 * Servers에 context.xml에 해당 내용을 넣었기 때문에 환경이 달라지면 안됨 > 이후에 프레임워크를 이용해서도 가능
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
	
	//반복되는 connection을 생성자를 통해 해결
	public Guest02Dao(){
		try {
			//커넥션 풀에 접근하기 위해 JNDI를 사용해야한다. JNDI는 서버에서 관리하는 리소스 정보 객체를 반환한다.
			//JNDI 서버 역활을 하는 객체를 생성, 리소스가 로컬에 있기 때문에 InitialContext만 생성하면 된다.
			InitialContext ic = new InitialContext();	
			
			// lookup는 리소스를 찾은후 Object객체를 반환 해준다.
			// 인자로 찾으려는 리소스의 등록된 이름을 지정한다.
			// java:/comp/env 는 WAS인 톰캣에서 리소스를 관리하는 가상 디렉터리
			// jdbc/oracle은 찾으려는 리소스의 이름
			this.source = (DataSource)ic.lookup("java:/comp/env/jdbc/oracle");//context.xml 에 있는 Resource 에서 설정한 name으로 lookup
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
				if(conn!=null) conn.close();	//maxidle 보다 클때 반환 된다.
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
