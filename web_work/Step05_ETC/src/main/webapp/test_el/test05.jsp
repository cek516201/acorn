<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test_el/test05.jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); // 한글이 깨지지 않도록
		String msg=request.getParameter("msg");
	%>
	<p> msg 라는 파라미터 명으로 전송된 내용 : <strong><%=msg %></strong></p>
	<%-- 위의 2 줄의 코딩 대신에 아래와 같이 응답할수도 있다 --%>
	<p> msg 라는 파라미터 명으로 전송된 내용 : <strong>${param.msg }</strong></p>
</body>
</html>