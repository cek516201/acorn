<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	MemberDto dto= new MemberDao().getData(Integer.parseInt(request.getParameter("num")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./member/insertform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/member/list.jsp">회원목록</a></li>
				<li class="breadcrumb-item active">회원수정</li>
			</ol>
		</nav>
		<h3>회원 수정 양식</h3>
		<form action="${pageContext.request.contextPath}/member/update.jsp" method="post">
		<div class="mb-3">
			<label class="form-label" for="num">번호</label>
			<input class="form-control" type="text" name="num" id="num" value="<%= dto.getNum() %>" readonly/>
		</div>
		<div class="mb-3">
			<label class="form-label" for="name">이름</label>
			<input class="form-control" type="text" name="name" id="name" value="<%= dto.getName() %>"/>
		</div>
		<div class="mb-3">
			<label class="form-label" for="addr">주소</label>
			<input class="form-control" type="text" name="addr" id="addr" value="<%= dto.getAddr() %>"/>
		</div>
		<button class="btn btn-primary" type="submit">수정</button>
		<button class="btn btn-secondary" type="reset">취소</button>
		</form>
	</div>
</body>
</html>