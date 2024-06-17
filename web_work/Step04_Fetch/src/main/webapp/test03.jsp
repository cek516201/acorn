<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test03.jsp</title>
</head>
<body>
	<button id="getBtn">회원정보 가져오기</button>
	<p>번호 : <strong id="num"></strong></p>
	<p>이름 : <strong id="name"></strong></p>
	<p>주소 : <strong id="addr"></strong></p>
	<script>
		document.querySelector("#getBtn").addEventListener("click",()=>{
			fetch("${pageContext.request.contextPath}/member.jsp").then(res=>res.json())
			.then((data)=>{
				document.querySelector("#num").innerText = data.num;
				document.querySelector("#name").innerText = data.name;
				document.querySelector("#addr").innerText = data.addr;
			});
		});
	</script>
	
	<button id="getBtn2">친구목록 가져오기</button>
	<button id="getBtn3">친구목록 가져오기2</button>
	<ul id="friends">
	
	</ul>
	<script>
	document.querySelector("#getBtn2").addEventListener("click", ()=>{
		fetch("${pageContext.request.contextPath}/friends.jsp").then(res=>res.json())
		.then((data)=>{
			data.forEach((elem)=>{
				const li = document.createElement("li");
				li.innerText = elem;
				document.querySelector("#friends").append(li);
			});
		});
	});
	
	document.querySelector("#getBtn3").addEventListener("click", ()=>{
		fetch("${pageContext.request.contextPath}/friends.jsp").then(res=>res.json())
		.then((data)=>{
			data.forEach((elem)=>{
				document.querySelector("#friends").insertAdjacentHTML("beforeend", `<li>\${elem}</li>`);
			});
		});
	});
	</script>
</body>
</html>