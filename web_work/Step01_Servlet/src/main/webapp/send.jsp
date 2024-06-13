<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 여기는 java 코딩 영역
String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send.jsp</title>
</head>
<body>
	<p>메시지 : <strong><% out.print(msg); %></strong></p>
	<p>메시지 : <strong><%= msg %></strong></p>
</body>
</html>