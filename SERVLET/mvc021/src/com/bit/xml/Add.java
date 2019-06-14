package com.bit.xml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.util.MyOracle;

public class Add extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sub = req.getParameter("sub");
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		String sql = "INSERT INTO bbs05 valuse(bbs05_seq.nextval,?,?,?,sysdate)";
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		int result = -1;
		
		conn = MyOracle.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();
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
}
