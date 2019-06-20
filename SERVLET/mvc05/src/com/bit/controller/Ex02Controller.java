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
 * annotation 방식
 * 서블릿을 상속받은 클래스에서 사용한다.
 * web.xml에 추가하지 않아도 된다.
 * 
 * 내부적으로 xml에 붙이기 때문에 annotation이 틀리면 xml에서 틀렸을 때와 같은 오류가 난다.
 * 서버가 실행되면 톰캣이 컨트롤러를 돌아다니면서 찾고 이를 xml에 추가시킨다.
 * xml을 수정 시켰을때와 같이 수정하면 서버를 새로 시작하는 것이 좋다.
 * 
 * 
 * 
 * */
//디폴트로 value @WebServlet(value="/ex02")
//@WebServlet("/ex02")
//@WebServlet(value={"/ex02.bit","/test02.nhn"})
//@WebServlet(urlPatterns="/ex02.git")
//@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"})
//@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"}, initParams={@WebInitParam(name="id",value="root")})	//파라미터 넘기기
@WebServlet(urlPatterns={"/ex02.bit","/test02.nhn"}, initParams={
		@WebInitParam(name="id",value="root"),
		@WebInitParam(name="pw",value="1234"),
		})	//파라미터 여러개 넘기기
public class Ex02Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>ABCDEFG</h1>");
		//파라미터 받기
		String val = this.getInitParameter("id");
		out.println("<p>id:"+val+"</p>");
		
		//파리미터 여러개 받기
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
		out.println("<p>id:"+id+" , pw : "+pw+"</p>");
		out.close();
	}
}
