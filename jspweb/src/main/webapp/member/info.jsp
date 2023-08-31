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

	<div class="signupWrap">	<!-- 마이페이지 전체구역 -->
		<div class="signupBox">
			<div class="signupTop">	<!-- 마이페이지 텍스트 -->
				마이페이지
			</div>
			<form class="signupForm">
				<div class="group">
					<div class="profiletext">프로필변경</div>
					<input onchange="preimg(this)" name="mimg"  class="mimg" type="file"><br/>
					<img class="preprofile" alt="" src="img/default.webp">		<!-- 등록 사진을 미리보기 할 사진 태그 -->
				</div>
				<div class="group">
					<label for="user" class="label">아이디</label>
					<div class="mid">qweqwe</div>
				</div>
				<div class="group">
					<label for="email" class="label">이메일</label>
					<div class="memail">qwe@qwe.com</div>
				</div>
				<div class="group">
					<label for="pass" class="label">기존 비밀번호</label>
					<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"/>
				</div>
				<div class="group">
					<label for="passchk" class="label">새로운 비밀번호</label>
					<input onkeyup="pwcheck()" name="newmpwd" class="newmpwd" type="password">
				</div>
			</form>
		</div>
			<!-- 수정, 탈퇴 버튼 -->
		<button class="updateBtn" onclick="mupdate()" type="button">수정</button>
		<button class="deleteBtn" onclick="mdelete()" type="button">탈퇴</button>
	</div>

	<script type="text/javascript" src = "../js/info.js"></script>
	<script type="text/javascript" src = "../js/signup.js"></script>
	
</body>
</html>