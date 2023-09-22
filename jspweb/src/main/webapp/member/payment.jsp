<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div>
		<button onclick="onAmount(1000)" type="button">1000포인트</button>
		<button onclick="onAmount(5000)" type="button">5000포인트</button>
		<button onclick="onAmount(10000)" type="button">10000포인트</button>
		<button onclick="onAmount(50000)" type="button">50000포인트</button>
		<button onclick="onAmount(100000)" type="button">100000포인트</button>
	</div>
	
	<div class="webcontainer">
		<button onclick="onPayMethod('card')" type="button">신용카드</button>
		<button onclick="onPayMethod('trans')" type="button">실시간 계좌이체</button>
		<button onclick="onPayMethod('vbank')" type="button">가상계좌</button>
		<button onclick="onPayMethod('phone')" type="button">휴대폰소액결제</button>
	</div>
	<div>
		<button onclick="requestPay()" type="button">결제하기</button>
	</div>

	<!-- 아임포트 라이브러리 -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script type="text/javascript" src="/jspweb/js/payment.js"></script>
	
</body>
</html>