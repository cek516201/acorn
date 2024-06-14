<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("msg : " + request.getParameter("msg"));
%>
<li><%= request.getParameter("msg") %></li>