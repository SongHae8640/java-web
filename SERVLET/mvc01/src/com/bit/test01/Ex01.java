package com.bit.test01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * ���� ����
 * 1. ���� dir ������ �����ϰ� ����� �� ���� ( jsp�� ������) >
 * 2. �ڹٸ� ����ϸ鼭 Ȯ����� Ŀ���� �� �� �ִ�. (���ϸ����� ������ �θ��� ���� �ƴ�)
 * 3. ���ȿ� �־ ����
 * 
 * ���� 
 * 1. ������. �Ұ� ����
 * 2. ������ ������ �� ����
 * */

public class Ex01 implements Servlet {
	ServletConfig  config;

	/*
	 * run �ϸ� http://localhost:8080/mvc01/WEB-INF/classes/com/bit/test01/Ex01.java 
	 * WEB-INF�� �׷� ������ �ƴ�(���� ������ ������ �� ���� �ּ�)
	 *  > �ּҸ� �ٲ��� �ʿ䰡 ���� > web.xml���� ����
	 * */
	@Override
	public void destroy() {
		//safe �ϰ� ���� �ɶ� 
		//build auto�� �߱� ������ �ڵ带 �����ϸ� destroy �ȴ�.(ũ�� ���� ����)
		//��û ���� ���������� ������ �������� ȣ��
		//�ڿ� �ݳ� �� 
		System.out.println("destroy() :: ");
		
		
		//���� ���� ���� �α׸� �����Ѵ� ������ �۾��� ���⼭
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() :: ");
		return config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() :: ");
		return "bit03 class...";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//������ ������ �� �ѹ� ȣ��
		//���� ���۽� �ʿ��� �۾��� ���⼭
		//���� ����
		
		System.out.println("init() :: ");
		config = arg0;
		
		
		
	}

	//�����ڰ� ����� �κ�!
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//��û�� ��� �ö� ���� ȣ��
		System.out.println("service() :: ");
//		System.out.println(config.getInitParameterNames());
		
		//����� ���� ����, ���� ���� ���� ����� �Ѵ�.
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
		

		
		//����ڿ��� ������ ���� response ��ü�� �̿�
		OutputStream output =  res.getOutputStream();
		PrintStream out = new PrintStream(output);
//		out.println("<h1>�ѱ�</h1>");

		
		//xml ������
		
		
		//json ������
		res.setContentType("application/json; charset=UTF-8");
		out.print("{\"root\":[{\"num\":\"1\" , \"name\":\"tester\"}]}");
		
		out.close();
		output.close();
	}

}
