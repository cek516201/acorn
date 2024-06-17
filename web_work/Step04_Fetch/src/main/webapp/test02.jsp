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
	<button id="sendBtn2">전송2</button>
	<button id="sendBtn3">전송3</button>
	<script>
		document.querySelector("#sendBtn").addEventListener("click",()=>{
			const msg = document.querySelector("#msg").value;
			fetch("${pageContext.request.contextPath}/send.jsp?msg=" + msg).then(res=>res.text())
			.then((data)=>{
				document.querySelector("p").innerText = data;
				console.log(data);
			});
		});
	</script>
	<p></p>
	<script>
		document.querySelector("#sendBtn2").addEventListener("click",()=>{
			const msg = document.querySelector("#msg").value;
			fetch("${pageContext.request.contextPath}/send2.jsp?msg=" + msg).then(res=>res.text())
			.then((data)=>{
				console.log(JSON.parse(data));
			});
		});
	</script>
	<script>
		document.querySelector("#sendBtn3").addEventListener("click",()=>{
			const msg = document.querySelector("#msg").value;
			fetch("${pageContext.request.contextPath}/send2.jsp?msg=" + msg).then(res=>res.json())
			.then((data)=>{
				console.log(data);
			});
		});
	</script>
</body>
</html>