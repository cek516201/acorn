<%@page import="test.user.dto.userDto"%>
<%@page import="test.user.dao.userDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isSuccess = false;

	String id = (String)session.getAttribute("id");
	String pwd = request.getParameter("pwd");
	String newPwd = request.getParameter("newPwd");
	
	String currentPwd = userDao.getInstance().select(id).getPwd();
	if(currentPwd.equals(pwd)){
		// 비밀번호 변경
		userDto dto = new userDto();
		dto.setId(id);
		dto.setPwd(newPwd);
		isSuccess = userDao.getInstance().updatePwd(dto);
	}
	if(isSuccess){
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/protected/pwd_update.jsp</title>
</head>
<body>
	<div class="container">
		<% if(isSuccess){ %>
			<p>
				비밀 번호를 수정하고 로그아웃 되었습니다.
				<br>
				<a href="${pageContext.request.contextPath}/user/loginform.jsp">다시 로그인</a>
			</p>
		<% } else { %>
			<p>
				구 비밀번호가 일치하지 않습니다.
				<br>
				<a href="${pageContext.request.contextPath}/user/private/pwd_updateform.jsp">다시 시도</a>
			</p>
		<% } %>
	</div>
</body>
</html>