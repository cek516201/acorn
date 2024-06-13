<%@page import="test.guest.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GuestDto> guests = GuestDao.getInstance().getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>./guest/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/include/navbar.jsp">
		<jsp:param value="guest" name="currentPage"/>
	</jsp:include>

	<div class="container">
		<h3 class="my-3">방명록</h3>
		<table class="table my-3 text-center table-striped-columns table-bordered">
			<colgroup>
				<col class="col-1"/>
				<col class="col-4"/>
				<col class="col-2"/>
				<col class="col-1"/>
				<col class="col-3"/>
				<col class="col-1"/>
			</colgroup>
			<thead>
				<tr class="table-info">
					<th>번호</th>
					<th>내용</th>
					<th>등록일</th>
					<th>작성자</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table-group-divider border-primary-subtle">
				<% for(var elem : guests){ %>
				<tr class="table-secondary">
					<td><%= elem.getNum() %></td>
					<td><textarea class="form-control" cols="30" rows="1" readonly><%= elem.getContent() %></textarea></td>
					<td><%= elem.getRegdate() %></td>
					<td><%= elem.getWriter() %></td>
					<td>
						<form action="${pageContext.request.contextPath}/guest/delete.jsp" method="post" class="input-group input-group-sm">
							<input type="hidden" name="num" value="<%= elem.getNum() %>"/>
							<input type="text" class="form-control form-control-sm" name="pwd" placeholder="비밀번호 입력"/>
							<button type="submit" class="btn btn-light btn-outline-danger btn-sm">삭제</button>
						</form>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/guest/updateform.jsp?num=<%= elem.getNum() %>" style="text-decoration: none">수정</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/guest/insertform.jsp" style="text-decoration: none">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  				<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  				<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
			</svg> 글쓰기
		</a>
	</div>
	
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>