package com.bit.json;

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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		String msg = "";
		
		int cnt= 0;
		
		msg+="{\"root\":[";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = MyOracle.getConnection();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM bbs05 order by num DESC");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(cnt >0) {
					msg+=",";
				}else{
					cnt++;
				}
				msg+="{";
				msg+="\"num\":\""+rs.getInt("num")+"\"";
				msg+=",\"sub\":\""+rs.getString("sub")+"\"";
				msg+=",\"content\":\""+rs.getString("content")+"\"";
				msg+=",\"name\":\""+rs.getString("name")+"\"";
				msg+=",\"nalja\":\""+rs.getDate("nalja")+"\"";
				msg+="}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		msg+="]}";
		resp.setContentType("application/json; charset=\"utf-8\"");
		
		PrintWriter out = resp.getWriter();
		out.print(msg);
		out.close();
	}
}
