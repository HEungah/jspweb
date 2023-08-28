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
		아이디 : <input onkeyup="idcheck()" class="mid" type="text"/>
		<span class="idcheckbox"></span>
		<br/>
		비밀번호 : <input onkeyup="pwcheck()" class="mpwd" type="password"/>
		<br/>
		비밀번호 확인 : <input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
		<span class="pwcheckbox"></span>
		<br/>
		이메일 : <input onkeyup="emailcheck()" class="memail" type="text"><button onclick="authRequest()" class="authReqBtn" disabled="disabled" type="button">인증요청</button>
		<span class="emailcheckbox"></span><br/>
		<div class="authbox">
		
		</div>
		프로필 : <input class="mimg" type="file">
		<button onclick="signup()" type="button">회원가입</button>
	</div>

	<script type="text/javascript" src = "../js/signup.js"></script>
	
</body>
</html>