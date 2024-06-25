<%@page import="test.user.dto.userDto"%>
<%@page import="test.user.dao.userDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	userDto dto = new userDto();
	dto.setId(request.getParameter("id"));
	dto.setPwd(request.getParameter("pwd"));
	dto.setEmail(request.getParameter("email"));
	
	boolean isSuccess = userDao.getInstance().insert(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/signup.jsp</title>
</head>
<body>
	<div class="container">
		<h1>알림</h1>
		<% if(isSuccess){ %>
			<p>
				<strong><%= request.getParameter("id") %></strong>님 가입 되었습니다.
				<br>
				<a href="${pageContext.request.contextPath}/user/loginform.jsp">로그인 하러 가기</a>
			</p>
		<% } else { %>
			<p>
				가입이 실패 했습니다.
				<br>
				<a href="${pageContext.request.contextPath}/user/signup_form.jsp">다시 가입하러 가기</a>
			</p>
		<% } %>
	</div>
</body>
</html>