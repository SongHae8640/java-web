package com.bit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet{
	//ex03.jsonp
	// 국내에는 jsonp가 잘 없음, 국내에서는 백엔드를 주로 이용 > 자바쪽에서 크롤링을 주로 함
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param = req.getParameter("callback");
		String msg ="";
		System.out.println(param);
		msg += param+"({\"root\" :[";
		msg +="                	{\"key1\" : \"value1\", \"key2\":\"value2\"},";
		msg +="                	{\"key1\" : \"value3\", \"key2\":\"value3\"}";
		msg +="          ]})";
		
		PrintWriter out = resp.getWriter();
		out.println(msg);
		out.close();
		
	}
}
