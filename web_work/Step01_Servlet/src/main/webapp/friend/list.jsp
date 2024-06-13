<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<String> names = new ArrayList<>();
	names.add("ㅁㅁㅁ");
	names.add("ㄴㄴㄴ");
	names.add("ㅇㅇㅇ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/list.jsp</title>
</head>
<body>
	<h3>친구 목록</h3>
	<ul>
		<% for(int i = 0; i < names.size(); i++){ %>
		<li><%= names.get(i) %></li>
		<% } %>
	</ul>
	
	<ul>
		<% for(var elem : names){ %>
		<li><%= elem %></li>
		<% } %>
	</ul>
</body>
</html>