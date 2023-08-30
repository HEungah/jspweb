<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="..\css\signup.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>

	<div class="signupWrap2">	<!-- 회원가입 전체구역 -->
		<div class="signupBox">
			<div class="signupTop">	<!-- 회원가입 텍스트 -->
				로그인
			</div>
			<form class="signupForm">
				<div class="group">
					<label for="user" class="label">아이디</label>
					<input name="mid" class="mid" type="text"/>
				</div>
				<div class="group">
					<label for="pass" class="label">비밀번호</label>
					<input name="mpwd" class="mpwd" type="password"/>
				</div>
				</form>
				<div class="logincheckbox"></div>
				<div class="findbtnbox">
					<a href="#">아이디찾기</a>
					<a href="#">비밀번호찾기</a>	
				</div>
			</div>	
			<!-- 로그인 유효성검사 구역 -->
			
			
		<button class="signupBtn" onclick="login()" type="button">로그인</button>
	</div>

	<script type="text/javascript" src = "../js/login.js"></script>
	
</body>
</html>