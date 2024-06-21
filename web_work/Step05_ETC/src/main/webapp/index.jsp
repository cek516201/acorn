<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${empty sessionScope.id}">
				로그아웃
				<br>
				<a href="${pageContext.request.contextPath}/user/loginform.jsp">로그인</a>
			</c:when>
			<c:otherwise>
				${sessionScope.id} 로그인
				<br>
				<a href="${pageContext.request.contextPath}/user/logout.jsp">로그아웃</a>
			</c:otherwise>
		</c:choose>
		<br>
		<ul>
			<li><a href="${pageContext.request.contextPath}/game/play.jsp">play</a></li>
			<li><a href="${pageContext.request.contextPath}/cafe/insertform.jsp">글쓰기</a></li>
		</ul>
	</div>
</body>
</html>