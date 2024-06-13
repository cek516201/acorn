<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	new MemberDao().delete(Integer.parseInt(request.getParameter("num")));
	// 특정 경로로 다시 요청을 하라는 리다이렉트 응답
	response.sendRedirect(request.getContextPath() + "/member/list.jsp");
%>