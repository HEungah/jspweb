<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/chatting.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
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
				<textarea onkeydown="onEnterKey()" class="msg" name="msg"></textarea>
				<button onclick="onSend()" type="button">전송</button>
			</div>
			
			<!-- 이모팈톤, 첨부파일 구역 -->
			<div class="dropdown">
			  <button class="emobtn" type="button" data-bs-toggle="dropdown">
			    <i class="far fa-smile"></i>
			  </button>
			  <ul class="dropdown-menu emolistbox">
			 
			  </ul>
			</div>
			
		</div>
		
		
		
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
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












