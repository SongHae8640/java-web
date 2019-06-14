package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	
	
	private MyOracle() {}

	public static Connection getConnection() {
		Connection conn =null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="hr";
		String password = "hr";
		
		try {
			if(conn ==null || conn.isClosed() ){
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
	}	
}
