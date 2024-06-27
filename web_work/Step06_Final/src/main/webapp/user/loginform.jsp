<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = request.getParameter("url");
	if(url == null){
		url = request.getContextPath() + "/index.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/loginform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="my-3">로그인 폼</h1>
		<form action="${pageContext.request.contextPath}/user/login.jsp" method="post">
			<div class="my-3">
				<label for="id" class="form-label">아이디</label>
				<input type="text" name="id" id="id" class="form-control"/>
			</div>
			<div class="my-3">
				<label for="pwd" class="form-label">비밀번호</label>
				<input type="password" name="pwd" id="pwd" class="form-control"/>
			</div>
			<input type="hidden" name="url" value="<%= url %>"/>
			<button type="submit" class="my-3 btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>