<%@page import="test.friend.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean deleteSuccess = new FriendDao().delete(Integer.parseInt(request.getParameter("num")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/delete</title>
</head>
<body>
	<script>
		<% if(deleteSuccess){ %>
			alert("삭제 성공");
		<% } else { %>
			alert("삭제 실패");
		<% } %>
		location.href = "${pageContext.request.contextPath}/friend/list.jsp";
	</script>
</body>
</html>