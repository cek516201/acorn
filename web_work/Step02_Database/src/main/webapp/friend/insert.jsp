<%@page import="test.friend.dto.FriendDto"%>
<%@page import="test.friend.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean insertSuccess = new FriendDao().insert(new FriendDto(0, request.getParameter("name"), request.getParameter("phoneNumber")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/insertform.jsp</title>
</head>
<body>
	<script>
		<% if(insertSuccess){ %>
			alert("친구 추가 성공");
		<% } else { %>
			alert("친구 추가 실패");
		<% } %>
		location.href = "${pageContext.request.contextPath}/friend/list.jsp";
	</script>
</body>
</html>