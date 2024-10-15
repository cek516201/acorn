<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
		<sec:authorize access="isAuthenticated()">
			<a href="${pageContext.request.contextPath}/user/info"><sec:authentication property="name"/></a> 님 로그인중
			<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
			<a href="${pageContext.request.contextPath}/user/signup_form">회원가입</a>
			<a href="${pageContext.request.contextPath}/user/loginform">로그인</a>
		</sec:authorize>
		
		<hr/>
		
		<%-- jstl의 if else  --%>
		<c:choose>
			<c:when test="${not empty sessionScope.userName}">
				<a href="${pageContext.request.contextPath}/user/info">${sessionScope.userName}</a> 님 로그인중
				<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/user/signup_form">회원가입</a>
				<a href="${pageContext.request.contextPath}/user/loginform">로그인</a>
			</c:otherwise>
		</c:choose>
	
		<h1>인덱스 페이지 입니다</h1>
		<p>
			jsp 페이지에서는  el 과  jstl 을 활용해서 request 영역에 담긴 내용을 추출해서
			클라이언트에게 출력할수 있다.
			request 영역에서 추출하는 기능은 el 이 담당하고 
			반복문은 jstl 을 활용한다.
		</p>
		<ul>
			<li><a href="${pageContext.request.contextPath}/file/list">자료실 목록보기</a></li>
		</ul>
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${notice}">
				<li>${tmp}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>