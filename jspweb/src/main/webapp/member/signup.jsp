<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/singup.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>

	<div>	<!-- 회원가입 전체구역 -->
		<form class="signupForm">
			아이디 : <input onkeyup="idcheck()" name="mid" class="mid" type="text"/>
			<span class="idcheckbox"></span>
			<br/>
			비밀번호 : <input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"/>
			<br/>
			비밀번호 확인 : <input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
			<span class="pwcheckbox"></span>
			<br/>
			이메일 : <input onkeyup="emailcheck()" name="memail" class="memail" type="text"><button onclick="authRequest()" class="authReqBtn" disabled="disabled" type="button">인증요청</button>
			<span class="emailcheckbox"></span><br/>
			<div class="authbox">
			
			</div>
			<!-- 태그명 이벤트명="함수명(this)" -->
			프로필 : <input onchange="preimg(this)" name="mimg"  class="mimg" type="file"><br/>
			<img class="preprofile" alt="" src="" width="100px">		<!-- 등록 사진을 미리보기 할 사진 태그 -->
			<button onclick="signup()" type="button">회원가입</button>
		</form>
	</div>

	<script type="text/javascript" src = "../js/signup.js"></script>
	
</body>
</html>