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

	<div class="signupWrap">	<!-- 회원가입 전체구역 -->
		<div class="signupBox">
			<div class="signupTop">	<!-- 회원가입 텍스트 -->
				회원가입
			</div>
			<form class="signupForm">
				<div class="group">
					<label for="user" class="label">아이디</label>
					<input onkeyup="idcheck()" name="mid" class="mid" type="text"/>
				</div>
				<span class="idcheckbox"></span>
				<div class="group">
					<label for="pass" class="label">비밀번호</label>
					<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"/>
				</div>
				<div class="group">
					<label for="passchk" class="label">비밀번호확인</label>
					<input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
				</div>
				<span class="pwcheckbox"></span>
				<div class="group">
					<label for="email" class="label">이메일</label>
					<input onkeyup="emailcheck()" name="memail" class="memail" type="text">
					<button onclick="authRequest()" class="authReqBtn" disabled="disabled" type="button">인증요청</button>
				</div>
				<span class="emailcheckbox"></span><br/>
				<div class="authbox">
				
				</div>
				<!-- 태그명 이벤트명="함수명(this)" -->
				<div class="group">
					<div class="profiletext">프로필</div>
					<input onchange="preimg(this)" name="mimg"  class="mimg" type="file"><br/>
					<img class="preprofile" alt="" src="img/default.webp">		<!-- 등록 사진을 미리보기 할 사진 태그 -->
				</div>
			</form>
		</div>
		<button class="signupBtn" onclick="signup()" type="button">회원가입</button>
	</div>

	<script type="text/javascript" src = "../js/signup.js"></script>
	
</body>
</html>