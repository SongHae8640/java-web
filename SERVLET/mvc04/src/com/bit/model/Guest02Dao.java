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
	
	DataSource source;	//인터페이스로 의존주입(ioc) 뒤에 스프링에서 배우게 될 것
	//톰켓이 Resource 를 지정해 놓으면 connection 객체를 준비함 이 객체와 war에서 생성된 connection을 연결
	//
	
	////// Context가 무엇인지 찾아볼것 ***
	//Servlet을 상속받은 객체는 getServletContext를 통해서 context를 가져올 수 있지만 dao는 아니기 때문에 
	//
	
	
	//반복되는 connection을 생성자를 통해 해결
	public Guest02Dao(){
		try {
			InitialContext init = new InitialContext();
			 Context context = (Context)init.lookup("java:/comp/env");
			 this.source = (DataSource) context.lookup("jdbc/oracle");	//context.xml 에 있는 Resourc 에서 설정한 name으로 lookup

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
		// 1.동시접속이 들어 왔을때 오류를 내는 것이 아니라
		// 접속을 보류 해서 앞 사람의 접속이 끝나면 그때 들어가게
		// 2. 접속할때 마다 연결하고 끊고 하는 것이 아니라 접속 객체를 만들어 놔서 이에 연결 하게		
		//https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html 에서 옵션을 보고 Servers의 tomcat에 context.xml 에 추가시킬것
		//Servers에 context.xml에 해당 내용을 넣었기 때문에 환경이 달라지면 안됨 > 이후에 프레임워크를 이용해서도 가능
		// 기능 요구서에서 env에서 idle에 대한 내용을 써둘것 
		
				
//		try {
//			InitialContext init = new InitialContext();
//			 Context context = (Context)init.lookup("java:/comp/env");
//			 source = (DataSource) context.lookup("jdbc/oracle");	//context.xml 에 있는 Resourc 에서 설정한 name으로 lookup
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
				if(conn!=null) conn.close();	//maxidle 보다 클때 반환 될것 임
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
		
//		//getList와는 다른 방식으로 해보자.
//		try {
//			InitialContext init = new InitialContext();
//			source = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");	//한번에 lookup하기
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
