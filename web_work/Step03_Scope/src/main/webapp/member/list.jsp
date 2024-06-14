<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<% for(var member : (List<MemberDto>)request.getAttribute("members")){ %>
				<tr>
					<td><%= member.getNum() %></td>
					<td><%= member.getName() %></td>
					<td><%= member.getAddr() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
	</div>
</body>
</html>