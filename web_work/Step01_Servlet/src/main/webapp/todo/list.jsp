<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<String> todos = new ArrayList<String>();
	todos.add("html 공부하기");
	todos.add("css 공부하기");
	todos.add("javascript 공부하기");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./todo/list.jsp</title>
<style>
	li{
		color:white;
		background-color:black;
	}
</style>
</head>
<body>
	<h3>할일 목록</h3>
	<ul>
		<% for(var elem : todos){ %>
		<li><%= elem %></li>
		<% } %>
	</ul>
</body>
</html>