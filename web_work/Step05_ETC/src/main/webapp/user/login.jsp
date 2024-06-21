<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isLoginSuccess = false;

	String id = request.getParameter("id");
	if(id.equals("gura") && request.getParameter("pwd").equals("1234")){
		session.setAttribute("id", id);
		isLoginSuccess = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/login.jsp</title>
</head>
<body>
	<div class="container">
		<% if(isLoginSuccess){ %>
		<p>
			<strong>${id}</strong> 로그인
			<br>
			<a href="${pageContext.request.contextPath}/index.jsp">인덱스로</a>
		</p>
		<% } else { %>
		<p>
			아이디 혹은 비밀번호가 틀립니다
			<br>
			<a href="${pageContext.request.contextPath}/user/loginform.jsp">다시 로그인</a>
		</p>
		<% } %>
	</div>
</body>
</html>