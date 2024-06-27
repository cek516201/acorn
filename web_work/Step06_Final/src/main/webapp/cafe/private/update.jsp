<%@page import="test.cafe.dto.CafeDto"%>
<%@page import="test.cafe.dao.CafeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int num = Integer.parseInt(request.getParameter("num"));

	CafeDto dto = new CafeDto();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setNum(num);

	boolean isSuccess = CafeDao.getInstance().update(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/private/update.jsp</title>
</head>
<body>
	<script>
		<% if(isSuccess){ %>
		alert("수정 성공");
		location.href="${pageContext.request.contextPath}/cafe/list.jsp";
		<% } else { %>
		alert("수정 실패");
		location.href="${pageContext.request.contextPath}/cafe/private/updateform.jsp?num=<%= dto.getNum() %>";
		<% } %>
	</script>
</body>
</html>