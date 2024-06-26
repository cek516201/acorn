<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty sessionScope.id}">
				<p>
					<a href="${pageContext.request.contextPath}/user/private/info.jsp">${id}</a> 로그인
					<br>
					<a href="${pageContext.request.contextPath}/user/logout.jsp">로그아웃</a>
				</p>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/user/loginform.jsp">로그인</a>
					<br>
					<a href="${pageContext.request.contextPath}/user/signup_form.jsp">회원가입</a>
				</p>
			</c:otherwise>
		</c:choose>
		<h1>인덱스</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/file/list.jsp">자료실 목록보기</a></li>
		</ul>
	</div>
</body>
</html>