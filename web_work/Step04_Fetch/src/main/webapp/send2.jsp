<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("msg : " + request.getParameter("msg"));
%>
{"isSuccess":true, "message":"수신 성공"}