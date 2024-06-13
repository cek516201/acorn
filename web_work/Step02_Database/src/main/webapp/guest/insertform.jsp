<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/insertform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/guest/list.jsp">방명록</a></li>
				<li class="breadcrumb-item active">글쓰기</li>
			</ol>
		</nav>
		<h1>글 작성</h1>
		<form action="${pageContext.request.contextPath}/guest/insert.jsp" method="post">
			<div>
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer"/>
			</div>
			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content" cols="30" rows="10"/></textarea>
			</div>
			<div>
				<label for="pwd">비밀번호</label>
				<input type="password" id="pwd" name="pwd"/>
			</div>
			<button type="submit">등록</button>
		</form>
	</div>
</body>
</html>