<%@page import="test.file.dto.FileDto"%>
<%@page import="java.util.List"%>
<%@page import="test.file.dao.FileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");

	//한 페이지에 몇개씩 표시할 것인지
	final int PAGE_ROW_COUNT=2;
	//하단 페이지를 몇개씩 표시할 것인지
	final int PAGE_DISPLAY_COUNT=2;
	
	//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
	int pageNum=1;
	
	//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
	String strPageNum=request.getParameter("pageNum");
	//만일 페이지 번호가 파라미터로 넘어 온다면
	if(strPageNum != null){
		//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
		pageNum=Integer.parseInt(strPageNum);
	}	
	
	//보여줄 페이지의 시작 ROWNUM
	int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
	//보여줄 페이지의 끝 ROWNUM
	int endRowNum=pageNum*PAGE_ROW_COUNT;
	
	//하단 시작 페이지 번호 
	int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
	//하단 끝 페이지 번호
	int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
	//전체 글의 갯수
	int totalRow=FileDao.getInstance().getCount();
	//전체 페이지의 갯수 구하기
	int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
	if(endPageNum > totalPageCount){
		endPageNum=totalPageCount; //보정해 준다. 
	}	

	//파일 전체 목록 얻어오기 
	//List<FileDto> list=FileDao.getInstance().getList();
	
	//pageNum 에 해당하는 목록만 얻어오기
	List<FileDto> list=FileDao.getInstance().getList(startRowNum, endRowNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
	/* ul 의 기본 스타일 제거 */
	.page-list{
		margin: 0;
		padding: 0;
		list-style-type: none;
	}
	
	.page-list li{
		float: left; /* li 가 필요한 만큼의 폭만 차지하면서 가로로 배치 되도록 */
		padding: 5px;
	}
	
	.page-list li:hover{
		background-color: #cecece;
	}
	
	.page-list li a{
		color: #000;
		text-decoration: none;
	}
	
	.page-list li.active a{
		color: red;
		text-decoration: underline;
		font-weight: bold;
	}
</style>
</head>
<body>
	<jsp:include page="/include/navbar.jsp">
		<jsp:param value="file" name="current"/>
	</jsp:include>
	<div class="container">
		<a href="${pageContext.request.contextPath}/file/private/upload_form.jsp">업로드</a>
		<h1>자료실 목록입니다</h1>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>파일명</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<% for(FileDto elem : list){ %>
				<tr>
					<td><%= elem.getNum() %></td>
					<td><%= elem.getWriter() %></td>
					<td><%= elem.getTitle() %></td>
					<td><a href="${pageContext.request.contextPath}/file/download.jsp?num=<%= elem.getNum() %>"><%= elem.getOrgFileName() %></a></td>
					<td><%= elem.getRegdate() %></td>
					
					<% if(elem.getWriter().equals(id)){ %>
					<td><a href="${pageContext.request.contextPath}/file/private/delete.jsp?num=<%= elem.getNum() %>">삭제</a></td>
					<% } %>
				</tr>
				<% } %>
			</tbody>
		</table>
		
		<ul class="page-list">
			<%--
				startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
			--%>
			<%if(startPageNum != 1){ %>
				<li>
					<a href="list.jsp?pageNum=<%=startPageNum-1 %>">Prev</a>
				</li>
			<%} %>
		
			<%for(int i=startPageNum; i<=endPageNum; i++){ %>
				<%if(i == pageNum){ %>
					<li class="active">
						<a href="list.jsp?pageNum=<%=i %>"><%=i %></a>
					</li>
				<%}else{ %>
					<li>
						<a href="list.jsp?pageNum=<%=i %>"><%=i %></a>
					</li>
				<%} %>	
			<%} %>
			
			<%--
				마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
			--%>
			<%if(endPageNum < totalPageCount){ %>
				<li>
					<a href="list.jsp?pageNum=<%=endPageNum+1 %>">Next</a>
				</li>
			<%} %>
		</ul>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>