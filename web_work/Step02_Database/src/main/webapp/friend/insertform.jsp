<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./friend/insertform.jsp</title>
</head>
<body>
	<h3>친구 추가 양식</h3>
	<form action="${pageContext.request.contextPath}/friend/insert.jsp" method="post">
		<input type="text" name="name" placeholder="이름 입력"/>
		<input type="text" name="phoneNumber" placeholder="전화번호 입력"/>
		<button type="submit">추가</button>
	</form>
</body>
</html>