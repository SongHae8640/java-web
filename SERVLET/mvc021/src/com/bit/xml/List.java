package com.bit.xml;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.util.MyOracle;

public class List extends HttpServlet{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/xml; charset=\"UTF-8\""); 
		PrintWriter out = resp.getWriter();
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<bbs05>");
		
		
		try {
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM bbs05 ORDER BY num DESC");
			rs = pstmt.executeQuery();
			while(rs.next()){
				out.print("	<row>");
				out.print("		<num>"+rs.getInt("num")+"</num>");
				out.print("		<sub>"+rs.getString("sub")+"</sub>");
				out.print("		<content>"+rs.getString("content")+"</content>");
				out.print("		<name>"+rs.getString("name")+"</name>");
				out.print("		<nalja>"+rs.getDate("nalja")+"</nalja>");
				out.print("	</row>");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		out.print("</bbs05>");
		out.close();
	}
}
