package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ּҸ� ���ؼ� ����� ���� = servlet
 * 
 *
 */
public class IndexController extends HttpServlet{
	//�ּҸ� index.bit�� ������
	
	//index�� view �� ����ϱ⿡ model ���� �ʴ´�.
	//request scope�� �����ϸ鼭 �ؾ��Ѵ�.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");	//���⿡ ���� ������ index.bit�� ���� �� ����
		rd.forward(req, resp);
	}
}
