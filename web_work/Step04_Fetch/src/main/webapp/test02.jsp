<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test02.jsp</title>
</head>
<body>
	<input type="text" id="msg" placeholder="메시지 입력" />
	<button id="sendBtn">전송</button>
	<script>
		document.querySelector("#sendBtn").addEventListener("click",()=>{
			const msg = document.querySelector("#msg").value;
			fetch("${pageContext.request.contextPath}/send.jsp?msg=" + msg).then(res=>res.text())
			.then((data)=>{
				document.querySelector("ul").insertAdjacentHTML("afterbegin", data);
				console.log(data);
			});
		});
	</script>
	<ul>

	</ul>
</body>
</html>