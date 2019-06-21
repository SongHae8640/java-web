package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guest02Dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Guest02Dao(){
		
	}
	
	private Connection getConnection(){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String password = "hr";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//addGuest와 addUser를 하나에서 처리
	public void add(String sub, int unum, int pay,String id, String pw, String name){
		getConnection();
		try {
			conn.setAutoCommit(false);
			addGuest(sub, unum, pay);
			addUser(id, pw, name);
			conn.commit();
			System.out.println("connection :: commit");
		} catch (SQLException e) {
			System.out.println("connection :: rollback");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void addGuest(String sub, int unum, int pay) throws SQLException{
		String sql = "INSERT INTO guest02 vlause(guest02_seq.nextval,?,?,SYSDATE,?)";
		int result = -1;
		
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sub);
		pstmt.setInt(2, unum);
		pstmt.setInt(3, pay);
		result = pstmt.executeUpdate();
	}
	
	public void addUser(String id, String pw, String name) throws SQLException{
		String sql = "INSERT INTO user02 vlause(user02_seq.nextval,?,?,?)";
		int result = -1;
		

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		result = pstmt.executeUpdate();

	}
}
