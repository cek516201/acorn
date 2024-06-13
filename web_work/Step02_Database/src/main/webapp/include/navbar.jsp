<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String currentPage = request.getParameter("currentPage");
%>

<%-- jsp 주석(웹 브라우저에 출력 안됨) --%>
<!-- 웹 브라우저 주석(웹 브라우저에 출력됨) -->
<nav class="navbar bg-primary navbar-expand-md" data-bs-theme="dark">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">Acorn</a>
		<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target=".navbar-collapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link <%= currentPage.equals("member") ? "active" : "" %>" href="${pageContext.request.contextPath }/member/list.jsp">회원목록</a>
				</li>
				<li class="nav-item">
					<a class="nav-link <%= currentPage.equals("guest") ? "active" : "" %>" href="${pageContext.request.contextPath }/guest/list.jsp">방명록</a>
				</li>
			</ul>
		</div>
	</div>
</nav>