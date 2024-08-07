<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파일 시스템 상에서 webapp의 upload 폴더까지의 절대경로를 얻어낸다
	String realPath = application.getRealPath("/upload");
	// 해당 경로를 access할 수 있는 객체 생성
	File f = new File(realPath);
	if(!f.exists()){
		f.mkdir(); // 업로드 폴더 만들기
	}
	
	// cos.jar에 있는 MultipartRequest 클래스로 객체 생성하기
	MultipartRequest mr = new MultipartRequest(request, // 내부적으로 필요한 HttpServletRequest 객체 전달
											   realPath, // 업로드할 파일을 저장할 경로
											   1024*1024*100, // 최대 업로드 사이즈 제한(byte)
											   "utf-8", // 한글 파일명 깨지지 않도록
											   new DefaultFileRenamePolicy()); // 동일한 파일이 존재하면 자동으로 파일을 rename해서 저장하도록

	/*
		위의 MultipartRequest 객체가 예외가 발생하지 않고 잘 생성되었다면 파일 업로드가 성공한 것이다
		따라서 mr에 들어있는 참조값을 이용해서 폼전송된 값을 추출해서 DB에 저장만 잘 하면 된다
	*/
	// title이라는 파라미터 명으로 전달되는 파일의 제목 얻어내기
	String title = mr.getParameter("title");
	// 업로드된 파일의 원본 파일명
	String orgFileName = mr.getOriginalFileName("myFile");
	// 업로드된 파일이 저장된 파일명(원본 파일명이랑 다를 수 있다)
	String saveFileName = mr.getFilesystemName("myFile");
	// 업로드된 파일의 크기(다운로드 해줄때 필요하다)
	long fileSize = mr.getFile("myFile").length();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/fileup/upload.jsp</title>
</head>
<body>
	<p>
		title : <strong><%=title %></strong> <br />
		원본 파일명 : <strong><%=orgFileName %></strong> <br />
		저장된 파일명 : <strong><%=saveFileName %></strong> <br />
		파일의 크기 : <strong><%=fileSize %></strong> byte <br />
		파일이 저장된 실제 경로 : <strong><%=realPath %></strong> <br />
		<a href="${pageContext.request.contextPath}/test/download?orgFileName=<%=orgFileName%>&saveFileName=<%=saveFileName%>&fileSize=<%=fileSize%>">다운로드</a>
	</p>
</body>
</html>