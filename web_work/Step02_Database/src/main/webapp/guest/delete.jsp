<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pwd = GuestDao.getInstance().getData(Integer.parseInt(request.getParameter("num"))).getPwd();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/delete.jsp</title>
</head>
<body>
	<script>
		<% if(request.getParameter("pwd").equals(pwd)){ %>
			<% if(GuestDao.getInstance().delete(Integer.parseInt(request.getParameter("num")))){ %>
				alert("삭제 성공");
			<% } else { %>
				alert("삭제 실패");
			<% } %>
		<% } else { %>
			alert("비밀번호가 다릅니다");
		<% } %>
		location.href = "${pageContext.request.contextPath}/guest/list.jsp";
	</script>
</body>
</html>