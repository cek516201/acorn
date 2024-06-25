<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- jstl-1.2.jar 파일에서 jsp/jstl/core 라이브러리를 import해서 c라는 접두어로 사용하겠다는 의미 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test_jstl/hello.jsp</title>
</head>
<body>
	<h1>java standard tag library(jstl)</h1>
	<c:forEach var="i" begin="0" end="9">
		<p>jstl <strong>${i}</strong></p>
	</c:forEach>
</body>
</html>