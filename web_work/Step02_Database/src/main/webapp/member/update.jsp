<%@page import="test.member.dto.MemberDto"%>
<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	boolean updateSuccess = new MemberDao().update(new MemberDto(Integer.parseInt(request.getParameter("num")), request.getParameter("name"), request.getParameter("addr")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./member/update.jsp</title>
</head>
<body>
	<script>
		<% if(updateSuccess){ %>
			alert("수정 성공");
			// 자바스크립트 redirect
			// location.href = "이동할 경로";
			location.href = "${pageContext.request.contextPath}/member/list.jsp";
		<% } else{ %>
			alert("수정 실패");
			location.href = "${pageContext.request.contextPath}/member/updateform.jsp?num=<%= request.getParameter("num") %>";
		<% } %>
			
	</script>
</body>
</html>