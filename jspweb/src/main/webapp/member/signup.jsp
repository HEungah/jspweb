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
		비밀번호 : <input class="mpwd" type="password"/>
		비밀번호 확인 : <input class="mpwdconfirm" type="password">
		이메일 : <input class="memail" type="text">
		이메일 인증코드 : <input class="ecord" type="text">
		프로필 : <input class="mimg" type="file">
		<button onclick="signup()" type="button">회원가입</button>
	</div>

	<script type="text/javascript" src = "../js/signup.js"></script>
	
</body>
</html>