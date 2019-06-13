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
 * 서블릿 장점
 * 1. 실제 dir 구조와 무관하게 사용할 수 있음 ( jsp와 대조적) >
 * 2. 자바를 사용하면서 확장명을 커스텀 할 수 있다. (파일명으로 파일을 부르는 것이 아님)
 * 3. 보안에 있어서 좋음
 * 
 * 단점 
 * 1. 불편함. 할게 많음
 * 2. 성능이 떨어질 수 있음
 * */

public class Ex01 implements Servlet {
	ServletConfig  config;

	/*
	 * run 하면 http://localhost:8080/mvc01/WEB-INF/classes/com/bit/test01/Ex01.java 
	 * WEB-INF는 그런 공간이 아님(보안 때문에 접근할 수 없는 주소)
	 *  > 주소를 바꿔줄 필요가 있음 > web.xml에서 변경
	 * */
	@Override
	public void destroy() {
		//safe 하게 종료 될때 
		//build auto로 했기 때문에 코드를 수정하면 destroy 된다.(크게 믿지 말것)
		//요청 받은 브라우저와의 연결이 끊어질때 호출
		//자원 반납 등 
		System.out.println("destroy() :: ");
		
		
		//서버 종료 이후 로그를 저장한다 던지의 작업을 여기서
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
		//서버를 생성할 때 한번 호출
		//서버 시작시 필요한 작업을 여기서
		//최초 세팅
		
		System.out.println("init() :: ");
		config = arg0;
		
		
		
	}

	//개발자가 사용할 부분!
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//요청이 들어 올때 마다 호출
		System.out.println("service() :: ");
//		System.out.println(config.getInitParameterNames());
		
		//헤더에 파일 형식, 문자 형식 등을 써줘야 한다.
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
		

		
		//사용자에게 보내기 위해 response 객체를 이용
		OutputStream output =  res.getOutputStream();
		PrintStream out = new PrintStream(output);
//		out.println("<h1>한글</h1>");

		
		//xml 문서로
		
		
		//json 문서로
		res.setContentType("application/json; charset=UTF-8");
		out.print("{\"root\":[{\"num\":\"1\" , \"name\":\"tester\"}]}");
		
		out.close();
		output.close();
	}

}
