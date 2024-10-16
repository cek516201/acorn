<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="${pageContext.request.contextPath}/gallery/upload_form">업로드 하러가기</a>
		<h1>갤러리 목록 입니다.</h1>
		<div class="row">
			<c:forEach var="tmp" items="${list}">
				<div class="col-sm-6 col-md-4 col-lg-3">
					<div class="card mb-3">
						<a href="${pageContext.request.contextPath}/gallery/detail?num=${tmp.num}">
							<div class="img-wrapper">
								<img class="card-img-top" src="${pageContext.request.contextPath}/upload/images/${tmp.saveFileName}" />
							</div>
						</a>
						<div class="card-body">
							<p class="card-text">${tmp.caption}</p>
							<p class="card-text">by <strong>${tmp.writer}</strong></p>
							<p><small>${tmp.regdate}</small></p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<nav>
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${startPageNum ne 1}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/gallery/list?pageNum=${startPageNum-1}">Prev</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="javascript:">Prev</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
					<li class="page-item ${i eq pageNum ? 'active' : ''}">
						<a class="page-link" href="${pageContext.request.contextPath}/gallery/list?pageNum=${i}">${i}</a>						
					</li>
				</c:forEach>
				
				<c:choose>
					<c:when test="${endPageNum lt totalPageCount}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/gallery/list?pageNum=${endPageNum+1}">Next</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="javascript:">Next</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>