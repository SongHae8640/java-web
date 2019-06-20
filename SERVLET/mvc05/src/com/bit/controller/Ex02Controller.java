package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * annotation ���
 * ������ ��ӹ��� Ŭ�������� ����Ѵ�.
 * web.xml�� �߰����� �ʾƵ� �ȴ�.
 * 
 * ���������� xml�� ���̱� ������ annotation�� Ʋ���� xml���� Ʋ���� ���� ���� ������ ����.
 * ������ ����Ǹ� ��Ĺ�� ��Ʈ�ѷ��� ���ƴٴϸ鼭 ã�� �̸� xml�� �߰���Ų��.
 * xml�� ���� ���������� ���� �����ϸ� ������ ���� �����ϴ� ���� ����.
 * 
 * 
 * 
 * */
//����Ʈ�� value @WebServlet(value="/ex02")
//@WebServlet("/ex02")
//@WebServlet(value={"/ex02.bit","/test02.nhn"})
//@WebServlet(urlPatterns="/ex02.git")
//@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"})
//@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"}, initParams={@WebInitParam(name="id",value="root")})	//�Ķ���� �ѱ��
@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"}, initParams={
		@WebInitParam(name="id",value="root"),
		@WebInitParam(name="pw",value="1234"),
		})	//�Ķ���� ������ �ѱ��
public class Ex02Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>ABCDEFG</h1>");
		//�Ķ���� �ޱ�
		String val = this.getInitParameter("id");
		out.println("<p>id:"+val+"</p>");
		
		//�ĸ����� ������ �ޱ�
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
		out.println("<p>id:"+id+" , pw : "+pw+"</p>");
		out.close();
	}
}
