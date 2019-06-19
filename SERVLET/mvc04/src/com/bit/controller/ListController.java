package com.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest02Dao;
import com.bit.model.Guest02Dto;

/**
 * -RequestDispatcher
 * a.jsp�� ���� ��û�� a.jsp ������ RequestDispatcher�� ����Ͽ� b.jsp�� ��û�� ���� �� �ִ�.
 * ���� a.jsp���� b.jsp�� ó���� ��û�ϰ� b.jsp���� ó���� ��� ������ a.jsp�� ����� ���� ��ų �� �ִ�.
 * ���� ������ request�� �̵��Ѵٰ� ���� �ȴ�.
 * 
 * -sendRedirect���� ����
 * sendRedirect�� ������ ��η� ��� �̵���Ű�� ��� �� �ϳ���. �׷��� HTTP �����̷����� �̿��ϱ� ������
 * �ϳ��� ��û ���� �ȿ��� ó���ϴ� ���� �ƴ϶� ���������� Response �� ������ ������ ���� ���� ��û ��η�
 * �ٽ� �� ��û�� �ϴ� ����̴�(�Դ� ����). ��Ű�� ������ �̿��� ������ �����ϴ�. 
 * + ���� ���ø����̼� �̿��� �ٸ� ��θ� ��û�� �� �ִ�.
 * 
 * -forword �޼���
 * �ش� jsp�� ��� �ڿ��� ��� �ѱ��. 
 * �ѱ� �ڿ���! ���� �ȴ�.
 */

public class ListController extends HttpServlet{
	// /bbs/list.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//model
		Guest02Dao dao = new Guest02Dao();
		req.setAttribute("list", dao.getList());
		
		//view
		//.jsp������ ����Ʈ �ּҴ� /mvc04/bbs/list.bit
		// web.xml���� ListController�� ����Ű�� �ּҴ� /bbs/list.bit
		// WebContent �Ʒ� bbs������ ����� ���ٸ� �Ʒ�ó��, �ƴ϶�� ../�� ���ؼ� ������
		RequestDispatcher rd = req.getRequestDispatcher("./list.jsp");
		rd.forward(req, resp);
	}
}
