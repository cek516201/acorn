<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/member.jsp</title>
</head>
<body>
	<div class="container">
		<p>번호 : <%= ((MemberDto)request.getAttribute("member")).getNum() %></p>
		<p>이름 : ${requestScope.member.getName()}</p>
		<%-- member.num 가능 --%>
		<p>주소 : ${member.addr}</p>
	</div>
</body>
</html>