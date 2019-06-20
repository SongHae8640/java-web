package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -CGI
 * ������ �����͸� �ٷ�� ������ �������� �����͸� �ٷ�� ����
 * �������� �ٸ� ���α׷��� �ҷ����� �� ���α׷��� ó������� Ŭ���̾�Ʈ��
 * �����ִ� �������̽��� CGI
 * ���μ��� ������ ������ ������ ��û�� �������� ���� ���ϰ� Ŀ����.
 * (>�̸� �ذ��ϱ� ���� ����� �� ���� ����)
 * 
 * -SERVLET
 * Servlet�� Tomcat�� �����Ҽ� �ִ� ���� Java �ڵ�θ� �̷���� �������� Ŭ�����̴�.
 * ���α׷��� ������ ������ ����Ǿ� ������ ���ϸ� ���δ�.
 * but, print �޼��带 ���ؼ� HTML ��Ŀ� ����� �ϴ� �������� �ִ�.
 * (> �̸� �ذ��ϱ� ���� ����� �� ���� JSP)
 * 
 * -JSP(java server page)
 * html�ȿ� �ڹ��ڵ尡 ���Ե� ������ ���� ���̵� ��ũ��Ʈ�� ���Ѵ�.
 * html �� ǥ�ؿ� ���� �ۼ��ǹǷ� �� �ۼ��� �����ϴ�.
 * Ŭ���̾�Ʈ���� ���񽺰� ��û�Ǹ� > jsp�� ������ �䱸�ϰ� 
 * > jsp�� �� ���ø����̼� ����(��Ĺ)�� ���� �����̳ʿ��� ���� �����ڵ�� ��ȯ�Ѵ�
 * 	> �� �����ڵ尡 �ٷ� ������ �� �Ŀ� ����� html ���·� Ŭ���̾�Ʈ�� �����ش�.
 * ��, jsp�� �ڵ带 ������ �� ���� was���� �ڵ����� �����ϰ� Ŭ���̾�Ʈ�� ȭ���� �������� �����ش�.(��)
 * 
 * */

public class Ex01Controller extends HttpServlet{
	public Ex01Controller() {
		//�������� �ٲ���(����� ��û�� ���͵�) �ѹ��� ������ > ������ �ϳ� �����ϰ� �̸� ����
		//cgi ��İ� �������� ������
		//cgi�� Ŭ���̾�Ʈ�� ���μ����� ó���ϴµ� ����, ������ Ŭ���̾�Ʈ�� ������� ó���Ѵ�.
		System.out.println("new Ex01Controller ... ");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>abcdef</h1>");
		
		//�Ķ���� �ޱ�
		String val = this.getInitParameter("id");
		out.println("<p>id:"+val+"</p>");
		
		Enumeration<String> enums = this.getInitParameterNames();
		while(enums.hasMoreElements()){
			String name = enums.nextElement();
			out.println("<p>"+name +": " +this.getInitParameter(name)+"</p>");
		}
		out.close();
	}
}
