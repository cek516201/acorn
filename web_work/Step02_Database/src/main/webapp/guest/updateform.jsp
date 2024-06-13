<%@page import="test.guest.dto.GuestDto"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestDto guest = GuestDao.getInstance().getData(Integer.parseInt(request.getParameter("num")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/updateform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/guest/list.jsp">방명록</a></li>
				<li class="breadcrumb-item active">수정</li>
			</ol>
		</nav>
		<h1>방명록 수정 폼</h1>
		<form action="${pageContext.request.contextPath }/guest/update.jsp" method="post">
			<div>
				<label for="num">번호</label>
				<input type="text" id="num" name="num" value="<%= guest.getNum() %>" readonly/>
			</div>
			<div class="form-floating my-3">
				<input type="text" class="form-control" id="writer" name="writer" placeholder="작성자 입력" value="<%= guest.getWriter()%>"/>
				<label for="writer">작성자</label>
			</div>
			<div>
				<label for="content">내용</label>
				<textarea id="content" name="content" rows="5"><%= guest.getContent() %></textarea>
			</div>
			<div>
				<label for="pwd">글 작성시 입력했던 비밀번호</label>
				<input type="password" id="pwd" name="pwd"/>
			</div>
			<button type="submit">수정확인</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>