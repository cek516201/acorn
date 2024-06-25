<%@page import="test.user.dto.userDto"%>
<%@page import="test.user.dao.userDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean loginSuccess = false;

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	userDto dto = userDao.getInstance().select(id);
	if(dto != null && dto.getPwd().equals(pwd)){
		// 로그인 성공
		session.setAttribute("id", id);
		loginSuccess = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/login.jsp</title>
</head>
<body>
	<% if(loginSuccess){ %>
		<p><strong><%= dto.getId() %></strong> 님 로그인 되었습니다.</p>
		<a href="${pageContext.request.contextPath}/index.jsp">인덱스로</a>
	<% } else { %>
		아이디 혹은 비밀번호가 틀립니다.
		<br>
		<a href="${pageContext.request.contextPath}/user/loginform.jsp">다시 로그인</a>
	<% } %>
</body>
</html>