<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("nick", request.getParameter("nick"));
	// 세션 유지시간 초단위로 설정
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/save.jsp</title>
</head>
<body>
	<p>세션에 <%= request.getParameter("nick") %> 저장</p>
	<p>30분동안 요청하지 않거나 웹브라우저를 끄면 자동 삭제</p>
	<a href="${pageContext.request.contextPath}/index.jsp">홈으로 이동</a>
</body>
</html>