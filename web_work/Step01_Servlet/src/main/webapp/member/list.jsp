<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dto.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberDto> members = new ArrayList<MemberDto>();
	members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
	members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
	members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./member/list.jsp</title>
</head>
<body>
	<h3>회원 목록</h3>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<% for(var member : members){ %>
				<tr>
					<td><%= member.getNum() %></td>
					<td><%= member.getName() %></td>
					<td><%= member.getAddr() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
</body>
</html>