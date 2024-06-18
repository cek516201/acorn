<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/validation/form2.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="my-3">폼 유효성 검증 style 테스트</h1>
		<form action="signup.jsp" method="post">
			<div class="my-3">
				<label class="form-label" for="nick">닉네임</label>
				<input class="form-control" type="text" name="nick" id="nick"/>
				<div class="invalid-feedback">이미 존재하는 닉네임 입니다!</div>
			</div>
			<div class="my-3">
				<label for="pwd">비밀번호</label>
				<input type="password" class="form-control" name="pwd" id="pwd"/>
				<div class="invalid-feedback">비밀 번호를 확인하세요</div>
			</div>
			<div class="my-3">
				<label for="pwd2">비밀번호 확인</label>
				<input type="password" class="form-control" id="pwd2"/>
			</div>
			<button class="btn btn-primary my-3" type="submit" disabled>가입</button>
		</form>
	</div>
	<script>
		document.querySelector("#nick").addEventListener("input", (e)=>{
			fetch("${pageContext.request.contextPath}/validation/check_nick.jsp?nick=" + e.target.value).then(res=>res.json())
			.then((data)=>{
				if(data.canUse){
					e.target.classList.remove("is-invalid");
					e.target.classList.add("is-valid");
				} else {
					e.target.classList.remove("is-valid");
					e.target.classList.add("is-invalid");
				}
				checkForm();
			})
		});
		
		document.querySelector("#pwd").addEventListener("input", (e)=>{ checkPwd(); });
		document.querySelector("#pwd2").addEventListener("input", (e)=>{ checkPwd(); });
		function checkPwd(){
			const pwd = document.querySelector("#pwd");
			if(pwd.value == document.querySelector("#pwd2").value && pwd.value != ""){
				pwd.classList.remove("is-invalid");
				pwd.classList.add("is-valid");
			} else {
				pwd.classList.remove("is-valid");
				pwd.classList.add("is-invalid");
			}
			checkForm();
		}
		
		function checkForm(){
			const submitBtn = document.querySelector("button[type=submit]");
			if(document.querySelector("#nick").classList.contains("is-valid") &&
			   document.querySelector("#pwd").classList.contains("is-valid")){
				submitBtn.removeAttribute("disabled");
			} else {
				submitBtn.setAttribute("disabled", "");
			}
		}
	</script>
</body>
</html>