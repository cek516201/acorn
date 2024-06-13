<%@page import="test.friend.dto.FriendDto"%>
<%@page import="test.friend.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean updateSuccess = new FriendDao().update(new FriendDto(Integer.parseInt(request.getParameter("num")), request.getParameter("name"), request.getParameter("phoneNumber")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/update.jsp</title>
</head>
<body>
	<script>
		<% if(updateSuccess){ %>
			alert("수정 성공");
		<% } else { %>
			alert("수정 실패");
		<% } %>
		location.href = "${pageContext.request.contextPath}/friend/list.jsp";
	</script>
</body>
</html>