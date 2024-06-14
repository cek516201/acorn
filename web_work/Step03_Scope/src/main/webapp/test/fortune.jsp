<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/fortune.jsp</title>
</head>
<body>
	<div class="container">
		<h3>오늘의 운세</h3>
		<p>오늘의 운세 : <strong><%= request.getAttribute("fortuneToday").toString() %></strong></p>
		<%-- EL을 이용하면 request 영역에 담긴 데이터를 key값으로 바로 추출할 수 있다 --%>
		<p>오늘의 운세 : <strong>${requestScope.fortuneToday}</strong></p>
		<%-- requestScope 생략 가능 --%>
		<p>오늘의 운세 : <strong>${fortuneToday}</strong></p>
	</div>
</body>
</html>