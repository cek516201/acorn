<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 초기화
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/logout.jsp</title>
</head>
<body>
	<script>
		alert("로그아웃");
		location.href = "${pageContext.request.contextPath}/index.jsp";
	</script>
</body>
</html>