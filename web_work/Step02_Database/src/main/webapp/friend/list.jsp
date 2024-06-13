<%@page import="test.friend.dao.FriendDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.friend.dto.FriendDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<FriendDto> friends = new FriendDao().getDatas();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/list.jsp</title>
</head>
<body>
	<h3>친구 목록</h3>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<% for(var elem : friends){ %>
			<tr>
				<td><%= elem.getNum() %></td>
				<td><%= elem.getName() %></td>
				<td><%= elem.getPhoneNumber() %></td>
				<td><a href="${pageContext.request.contextPath}/friend/delete.jsp?num=<%= elem.getNum() %>">삭제</a></td>
				<td><a href="${pageContext.request.contextPath}/friend/updateform.jsp?num=<%= elem.getNum() %>">수정</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/friend/insertform.jsp">친구 추가</a>
</body>
</html>