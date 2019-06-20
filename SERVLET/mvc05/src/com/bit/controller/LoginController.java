package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.model.User02Dao;

@WebServlet("/login/form.bit")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		User02Dao dao = new User02Dao();
		if(dao.login(id, pw)){
			// session
			//사용자가 보낸 정보 req를 통해 받는다.
			HttpSession session = req.getSession();
			session.setAttribute("result", true);
			session.setAttribute("id", id);
			
			resp.sendRedirect(req.getContextPath());
		}else{
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"id와 pw를 다시확인\")</script>");
			doGet(req, resp);
		}
		
		
	}
}
