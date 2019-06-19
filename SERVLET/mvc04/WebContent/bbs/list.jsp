<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.model.Guest02Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- CDN 방식 https://code.jquery.com/
CDN 방식은 읽어와서 파일로 저장한 후에 사용, 변화가 없으면 다운 받은걸 그대로 사용
CDN 장점 : 사이트에서 바로 읽어 오는데 대부분의 사이트들이 jquery를 사용하기 때문에 그대로 사용 > 빠름
	>많이 사용되는 CDN을 사용해야 다운을 받지 않음
개발단계에서 서버를 올리고 내리고 할때는 비효율, but 사용단계에서는 효율적
네트워크가 연결 되지 않으면 사용 불가-->
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$('#content>table+button').click(function(){
			window.location.href = "add.bit";
		})
		
	});
</script>
<style type="text/css">
	body>div{
		width: 800px;
		margin : 0px auto;
	}
	#content>div{
		width: 600px;
		height: 400px;
		margin : 0px auto;
		border: 1px solid gray;
	}
	#content td>a{
		display: block;
		text-decoration: none;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="header">
			<h1>로고 이미지</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/mvc04/">HOME</a></li>
				<li><a href="/mvc04/intro">INTRO</a></li>
				<li><a href="/mvc04/bbs/list.bit">BBS</a></li>
				<li><a href="/mvc04/login">LOGIN</a></li>
			</ul>
		</div>
		<div id="content">
			<h2>리스트 페이지</h2>
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>금액</th>
					</tr>
				</thead>
				<tbody>
				<%
				ArrayList<Guest02Dto> list =null;
				list =(ArrayList<Guest02Dto>)request.getAttribute("list");
				
				for(Guest02Dto bean : list){
				%>
					<tr>
						<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
						<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getSub() %></a></td>
						<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getName() %></a></td>
						<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getPay() %></a></td>
					</tr>
				<%
				}	
				%>
				</tbody>
			</table>
			<button>추가</button>
		</div>
		<div id="footer">
			Copyright &copy; 비트캠프 all rights reserved
		</div>
	</div>

</body>
</html>