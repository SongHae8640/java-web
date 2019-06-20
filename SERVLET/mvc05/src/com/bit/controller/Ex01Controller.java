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
 * 정적인 데이터만 다루던 웹에서 동적으로 데이터를 다루기 위해
 * 서버에서 다른 프로그램을 불러내고 그 프로그램의 처리결과를 클라이언트로
 * 보내주는 인터페이스가 CGI
 * 프로세스 단위로 실행이 됨으로 요청이 많아지면 서버 부하가 커진다.
 * (>이를 해결하기 위해 만들어 진 것이 서블랫)
 * 
 * -SERVLET
 * Servlet은 Tomcat이 이해할수 있는 순수 Java 코드로만 이루어진 웹서버용 클래스이다.
 * 프로그램을 스레드 단위로 실행되어 서버의 부하를 줄인다.
 * but, print 메서드를 통해서 HTML 양식에 맞춰야 하는 불편함이 있다.
 * (> 이를 해결하기 위해 만들어 진 것이 JSP)
 * 
 * -JSP(java server page)
 * html안에 자바코드가 포함된 것으로 서버 사이드 스크립트를 말한다.
 * html 웹 표준에 따라 작성되므로 웹 작성이 용이하다.
 * 클라이언트에서 서비스가 요청되면 > jsp의 실행을 요구하고 
 * > jsp는 웹 어플리케이션 서버(톰캣)의 서블릿 컨테이너에서 서블릿 원시코드로 변환한다
 * 	> 그 원시코드가 바로 컴파일 된 후에 결과를 html 형태로 클라이언트에 돌려준다.
 * 즉, jsp는 코드를 변경할 때 마다 was에서 자동으로 빌드하고 클라이언트에 화면을 동적으로 보여준다.(편리)
 * 
 * */

public class Ex01Controller extends HttpServlet{
	public Ex01Controller() {
		//브라우저가 바껴도(사용자 요청이 들어와도) 한번만 생성됨 > 서블랫을 하나 생성하고 이를 재사용
		//cgi 방식과 서블랫과의 차이점
		//cgi는 클라이언트를 프로세스로 처리하는데 반해, 서블릿은 클라이언트를 스레드로 처리한다.
		System.out.println("new Ex01Controller ... ");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>abcdef</h1>");
		
		//파라미터 받기
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
