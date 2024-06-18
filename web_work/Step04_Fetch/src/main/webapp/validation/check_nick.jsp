<%@ page language="java" contentType="application.json; charset=UTF-8"
    pageEncoding="UTF-8"%>
{"canUse" : <%= !request.getParameter("nick").equals("gura") %>}