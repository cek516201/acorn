<%@page import="test.cafe.dao.CafeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	boolean isSuccess = CafeDao.getInstance().delete(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/private/delete.jsp</title>
</head>
<body>
	<script>
		<% if(isSuccess){ %>
		alert("삭제 성공");
		location.href="${pageContext.request.contextPath}/cafe/list.jsp";
		<% } else { %>
		alert("삭제 실패");
		location.href="${pageContext.request.contextPath}/cafe/detail.jsp?num=<%= num %>";
		<% } %>
	</script>
</body>
</html>