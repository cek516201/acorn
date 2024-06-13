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
	</div>
</body>
</html>