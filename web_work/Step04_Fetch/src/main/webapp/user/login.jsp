<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isValid = false;
	if(request.getParameter("id").equals("gura") && request.getParameter("pwd").equals("1234")){
		isValid = true;
	}
%>
{"isSuccess":<%= isValid %>}