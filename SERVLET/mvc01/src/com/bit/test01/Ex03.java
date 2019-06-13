package com.bit.test01;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Ex02와 같은 거라고 보면 된다. 
public class Ex03 extends javax.servlet.GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//io를 뽑기 전에 type 설정을 해줘야 한다.
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.print("<!doctype html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>서블릿 페이지 </h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

}
