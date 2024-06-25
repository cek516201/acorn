<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	List<MemberDto> list = new ArrayList<>();
	list.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
	list.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
	list.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
	
	request.setAttribute("list", list);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test_jstl/test03.jsp</title>
</head>
<body>
	<h1>회원목록</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${requestScope.list}">
			<tr>
				<td>${member.num}</td>
				<td>${member.name}</td>
				<td>${member.addr}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>