<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test01.jsp</title>
</head>
<body>
	<h3>fetch 테스트</h3>
	<button id="myBtn">버튼</button>
	<script>
		document.querySelector("#myBtn").addEventListener("click",()=>{
			// 1. jsp로 요청
			fetch("${pageContext.request.contextPath}/index.jsp")
			.then((res)=>{
				// 2. 요청에 대한 응답을 받으면 실행
				/*
					서버에서 응답한 문자열이 json 형식이면
					return res.json();
				
					그 이외의 형식(html, xml, plain text 등)이면
					return res.text();
				*/
				return res.text();
			})
			.then((data)=>{
				// 3. 위의 함수가 리턴되면 실행
				/*
					위의 then() 함수에서 res.json()을 리턴했으면
					data는 json.parse() 과정을 이미 거친 object 또는 array
					
					위의 then() 함수에서 res.json()을 리턴했으면
					data는 string
				*/
				console.log(data);
			});
		});
	</script>
	<a href="${pageContext.request.contextPath}/index.jsp">링크</a>
</body>
</html>