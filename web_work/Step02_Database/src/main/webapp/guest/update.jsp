<%@page import="test.guest.dto.GuestDto"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isSuccess = false;
	String pwd = GuestDao.getInstance().getData(Integer.parseInt(request.getParameter("num"))).getPwd();
	// 비밀번호 일치 시
	if(pwd.equals(request.getParameter("pwd"))){
		isSuccess = GuestDao.getInstance().update(new GuestDto(Integer.parseInt(request.getParameter("num")),
												  			   request.getParameter("writer"),
												  			   request.getParameter("content"),
												  			   null,
												  			   null));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/updateform.jsp</title>
</head>
<body>
	<div class="container">
		<h3>알림</h3>
		<% if(isSuccess){ %>
			<p>
				수정 성공
				<a href="${pageContext.request.contextPath}/guest/list.jsp">목록 보기</a>
			</p>
		<% } else { %>
			<p>
				수정 실패
				<a href="${pageContext.request.contextPath}/guest/updateform.jsp?num=<%= request.getParameter("num") %>">다시 수정</a>
			</p>
		<% } %>
	</div>
</body>
</html>