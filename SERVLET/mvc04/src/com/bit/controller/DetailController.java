package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest02Dao;
import com.bit.model.Guest02Dto;

public class DetailController extends HttpServlet{
	// /detail.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("idx"));
		
		Guest02Dao dao = new Guest02Dao();
		
		req.setAttribute("bean", dao.detail(num));
		
		RequestDispatcher rd = req.getRequestDispatcher("../detail.jsp");
		rd.forward(req, resp);
	}
}
