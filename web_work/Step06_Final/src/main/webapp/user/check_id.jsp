<%@page import="test.user.dto.userDto"%>
<%@page import="test.user.dao.userDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	userDto dto = userDao.getInstance().select(id);
%>
{"canUse":<%= dto == null %>}