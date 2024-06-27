<%@page import="java.net.URLEncoder"%>
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
	
	String url = request.getParameter("url");
	// 로그인 실패를 대비해서 목적지 정보를 인코딩한 결과도 준비
	String encodedUrl = URLEncoder.encode(url);
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
		<a href="<%= url %>">확인</a>
	<% } else { %>
		아이디 혹은 비밀번호가 틀립니다.
		<br>
		<a href="${pageContext.request.contextPath}/user/loginform.jsp?url=<%= encodedUrl %>">다시 로그인</a>
	<% } %>
</body>
</html>