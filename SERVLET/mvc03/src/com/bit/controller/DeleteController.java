package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest01Dao;

public class DeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("idx"));
		Guest01Dao dao = new Guest01Dao();
		dao.delete(num);
		
		//insert update delete�� post����� ��� ����
		//select ����� db�� ū ������ ��ġ�� �ʱ� ������ post��ĵ� ����
	}
}
