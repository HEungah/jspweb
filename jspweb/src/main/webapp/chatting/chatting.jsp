<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/chatting.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="webcontainer">
		<!-- 채팅전체구역 -->
		<div class="chatbox">
			<!-- 채팅내용 목록 -->
			<div class="chatcont">
				<!-- 채팅출력구역(js에서 출력) -->
			</div>
			<!-- 채팅입력창, 전송버튼 -->
			<div class="chatbottom">
				<textarea class="msg" autofocus></textarea>
				<button onclick="onSend()" type="button">전송</button>
			</div>
			
		
		</div>
		
		
		
	</div>



	<script type="text/javascript" src="/jspweb/js/chatting.js"></script>

</body>
</html>



				<!--  보냈을때 메시지 [오른쪽]
				<div class="rcont">
					<div class="subcont">
						<div class="date">오전 10:02</div>
						<div class="content">안녕하세욥</div>
					</div>
				</div>
				
				알림 메시지
				<div class="alram">ooo님이 입장 하셨습니다.</div>
				
				받았을때 메시지 [왼쪽]
				<div class="lcont">
					보낸사람 프로필
					<img class="pimg" src="/jspweb/member/img/default.webp"/>
					<div class="tocont">
						<div class="name">유재석</div>	보낸 사람
						<div class="subcont">
							<div class="content">반가워요</div>
							<div class="date">오전 10: 10</div>
						</div>
					</div>
				</div> -->












