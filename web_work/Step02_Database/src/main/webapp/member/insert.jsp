<%@page import="test.member.dto.MemberDto"%>
<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isAllowedName = true;
	String name = request.getParameter("name").trim();
	boolean isAllowedAddr = true;
	String addr = request.getParameter("addr").trim();
	boolean insertSuccess = false;
	
	if(name == ""){
		isAllowedName = false;
	} else if(addr == ""){
		isAllowedAddr = false;
	} else if(new MemberDao().insert(new MemberDto(0, name, addr))){
		insertSuccess = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./member/insert.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<% if(!isAllowedName){ %>
		<p class="alert alert-warning">잘못된 이름입니다&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/list.jsp">목록 보기</a></p>
	<% } else if(!isAllowedAddr){ %>
		<p class="alert alert-warning">잘못된 주소입니다&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/list.jsp">목록 보기</a></p>
	<% } else if(!insertSuccess){ %>
		<p class="alert alert-warning">DB에 회원 추가 실패&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/list.jsp">목록 보기</a></p>
	<% } else{ %>
		<p class="alert alert-success">DB에 회원 추가 성공&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/list.jsp">목록 보기</a></p>
	<% } %>
	
</body>
</html>