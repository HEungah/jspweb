<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/header.css" rel="stylesheet">
</head>
<body>
	
	<!-- 헤더 -->
	<div id="header">
		<div class="mainlogo">	<!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/weblogo.png"/>
			</a>
		</div>
		<!-- 본메뉴 -->
		<ul  class="mainmenu">
			<li><a href="/jspweb/visitlog/visitlog.jsp">방문록</a></li>
			<li><a href="/jspweb/board/list.jsp">게시판</a></li>
			<li><a href="/jspweb/datago/datago.jsp">공공데이터</a></li>
			<li><a href="/jspweb/chatting/chatting.jsp">채팅</a></li>
			<li><a href="/jspweb/accountbook/accountbook.jsp">가계부</a></li>
			<li><a href="#">열람실</a></li>
			<li><a href="/jspweb/product/register.jsp">제품등록</a></li>
			<li><a href="/jspweb/hrm/hrm.jsp">인사관리</a></li>
		</ul>
		<!-- 서브메뉴 -->
		<ul class="submenu">
			
		</ul>	
	</div>
	
	
	
	<!-- jquery -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- js -->
	<script type="text/javascript" src="/jspweb/js/header.js"></script>
		
</body>
</html>

<!-- 
		헤더는 많은 페이지에서 참조하는 페이지 이므로 공통적인 코드를 넣는다
			1. 라이브러리

 -->

