<%@page import="com.bit.model.Guest01Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table{
		border-collapse: collapse;
		border: 1px solid gray;
		width: 600px;
	}
	table>thead>tr{
		border: 1px solid gray;
	}
	table>tbody{}
	table>tbody>tr{}
	table>tbody>tr:nth-child(2n){
		background-color: #cccccc;
	}
	table>tbody>tr>td{
		border: 1px solid gray;
	}
	table>tbody>tr>td>a{
		display: block;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('button').click(function(){
			//add할때는 bean객체를 전달 할 필요 없기 때문에 바로 주소로 이동한다.
			window.location.href="add.jsp";
		})
	})
</script>
</head>
<body>
	<h1>리스트 페이지</h1>
	<table>
		<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		</thead>
		<tbody>
		<%
			ArrayList<Guest01Dto> list = (ArrayList<Guest01Dto>)request.getAttribute("alist");
			
			for(int i =0 ; i <list.size(); i++){
				Guest01Dto bean = list.get(i);
		%>
		
		<tr>
			<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
			<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getSub() %></a></td>
			<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getNalja() %></a></td>
			<td><a href="detail.bit?idx=<%=bean.getNum() %>"><%=bean.getPay() %></a></td>
		</tr>
		<%
			}
		%>
		
		</tbody>
	</table>
	<button type="button">입력</button>

</body>
</html>