<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  	<script type="text/javascript">
		//jquery로 이용하기
		var btn, file, xhr;
		$(document).ready(function(){
			$('button').click(function(){ 
				var input = document.querySelector('#myFile');
				var formData = new FormData();
				formData.append('myfile', input.files[0])
				
				$.ajax({
					url : 'upload.bit',
					processData: false, 
					contentType: false,
					type: 'POST', 
					data : formData,
					success: function(data){ 
						alert("EE"); 
					}

				})
			});
			
		});
		
		
	</script>
	
	<!--
	<script type="text/javascript">
		var btn, file, xhr;
		window.onload = function(){
			alert("onload");
			btn = document.querySelector('button');


			btn.onclick = function() {
				var fileData = new FormData();
				file = document.querySelector('#myFile');
				
				//form으로 보낸 것과 같은 방식
				fileData.append("myfile", file.files[0]);

				alert('버튼 클릭');
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = upload();
				xhr.open('post', 'upload.bit', true);
				xhr.send(fileData);
			}

		};

		function upload() {
			//xhr.readyState 는 4번 실행 하는데 마지막에만 처리 할 것이기 때문에
			if (xhr.readyState == 4 ) {
				if(xhr.status ==200){
					alert('업로드 완료');
				}else{//에러 일때
					
				}
			}
		}
		
		//함수명의 첫글자를 대문자로 하면 객체 생성용
		//fuction이랑 같은 기능을 하는 class도 있음
		function My(){
			this.num = 1;
		}
		var myTest = new My();
		console.log("My num :: "+myTest.num);

	</script>
	-->
</head>

<body>
	<h1>ajax 파일 업로드</h1>
	<div>
		<input type="file" id="myFile">
	</div>
	<div>
		<button>upload</button>
	</div>
</body>

</html>
