<%@page import="test.guest.dto.GuestDto"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isSuccess = GuestDao.getInstance().insert(new GuestDto(0,
																   request.getParameter("writer"),
																   request.getParameter("content"),
																   request.getParameter("pwd"),
																   null));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/insert.jsp</title>
</head>
<body>
	<div class="container">
		<h3>알림</h3>
		<% if(isSuccess){ %>
			<p>글 저장 성공</p>
			<a href="${pageContext.request.contextPath}/guest/list.jsp">목록보기</a>
		<% } else { %>
			<p>글 저장 실패</p>
			<a href="${pageContext.request.contextPath}/guest/insertform.jsp">다시 작성</a>
		<% } %>
	</div>
</body>
</html>