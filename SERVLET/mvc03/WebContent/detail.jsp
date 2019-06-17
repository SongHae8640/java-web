<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<jsp:useBean id="bean" scope="request" class="com.bit.model.Guest01Dto"></jsp:useBean>
<script type="text/javascript">
	$(document).ready(function(){
		$('div>a').last().click(function(){
			window.history.back();
			return false;
		}).prev().click(function(){
			var result=confirm('삭제하시겠습니까?');
			if(result){
				$.ajax({
					url:'delete.bit',
					method:'post',
					data:'idx='+<%=bean.getNum()%>,
					error:function(){
						alert('삭제실패');
					},
					success:function(){
						window.location.href='list.bit';
					}
				});
			}
			return false;
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 페이지</h1>
	<div>
		<span>글번호</span>
		<span><jsp:getProperty name="bean" property="num"/></span>
	</div>
	<div>
		<span>제목</span>
		<span><jsp:getProperty name="bean" property="sub"/></span>
	</div>
	<div>
		<span>날짜</span>
		<span><jsp:getProperty name="bean" property="nalja"/></span>
	</div>
	<div>
		<span>금액</span>
		<span><jsp:getProperty name="bean" property="pay"/></span>
	</div>
	<div>
		<a href="edit.bit?idx=<%=request.getParameter("idx")%>">수정</a>
		<a href="#">삭제</a>
		<a href="#">뒤로</a>
	</div>
</body>
</html>