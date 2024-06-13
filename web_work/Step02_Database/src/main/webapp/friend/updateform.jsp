<%@page import="test.friend.dto.FriendDto"%>
<%@page import="test.friend.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FriendDto friend = new FriendDao().select(Integer.parseInt(request.getParameter("num")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/updateform.jsp</title>
</head>
<body>
	<h3>친구 수정 양식</h3>
	<form action="${pageContext.request.contextPath}/friend/update.jsp?num=<%= request.getParameter("num") %>" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" value="<%= friend.getName() %>"/>
		&nbsp;
		<label for="phoneNumber">전화번호</label>
		<input type="text" name="phoneNumber" id="phoneNumber" value="<%= friend.getPhoneNumber() %>"/>
		<button type="submit">수정</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>