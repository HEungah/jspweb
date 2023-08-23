<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css import -->
	<link href="accountbook.css" rel="stylesheet">
</head>
<body>
	
	<!-- CRUD(Restful Api) 기반의 가계부 구현 -->
	<div class="accountWrap">	<!-- 전체 구역 -->
		<div class="accountTop"> <!-- 입력구역 -->
			<input class="aItem" type="text" placeholder="항목">
			<input class="aPayment" type="text" placeholder="금액">
			<input class="aDate" type="date">
			<button onclick="inputAccount()" type="button">등록</button>
		</div>
		<div class="accountBottom"> <!-- 출력구역 -->
		</div>
	
	</div>


	<!-- jquery -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script type="text/javascript" src="accountbook.js"></script>
</body>
</html>