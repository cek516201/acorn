<%@page import="test.cafe.dto.CafeDto"%>
<%@page import="test.cafe.dao.CafeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String writer = (String)session.getAttribute("id");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	CafeDto dto = new CafeDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	boolean isSuccess = CafeDao.getInstance().insert(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/private/insert.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card w-50 mt-5">
			<%if(isSuccess){ %>
				<div class="card-body">
					<h5 class="card-title">알림</h5>
					<p class="card-text"><%=writer %>  님이 작성한 새글을 저장했습니다</p>
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/cafe/list.jsp">확인</a>
				</div>
			<%}else{ %>
				<div class="card-body">
					<h5 class="card-title">알림</h5>
					<p class="card-text text-danger">글 저장 실패!</p>
					<a class="btn btn-warning" href="${pageContext.request.contextPath}/cafe/private/insertform.jsp">다시 작성하기</a>
				</div>
			<%} %>
		</div>
	</div>
</body>
</html>