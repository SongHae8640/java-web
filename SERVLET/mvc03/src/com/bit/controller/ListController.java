package com.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest01Dao;
import com.bit.model.Guest01Dto;

public class ListController extends HttpServlet{
	//list.bit
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//db에서 값을 가져옴
		//model
		Guest01Dao dao = new Guest01Dao();
		ArrayList<Guest01Dto> list = dao.getList();
		
		//이를 화면에 에 뿌려줌
		//view
		//controller에서 jsp까지 라이프 사이클을 생각해서 req에 값을 실어서 보냄
		//session때와 같음
		req.setAttribute("alist", list);
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}
