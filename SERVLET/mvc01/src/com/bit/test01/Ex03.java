package com.bit.test01;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Ex02�� ���� �Ŷ�� ���� �ȴ�. 
public class Ex03 extends javax.servlet.GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//io�� �̱� ���� type ������ ����� �Ѵ�.
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.print("<!doctype html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>���� ������ </h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

}
