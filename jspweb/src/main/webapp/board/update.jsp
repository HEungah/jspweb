<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/update.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="updateWrap">	<!-- 수정페이지 전체화면 -->
		<div class="updateBox">
			<form class="updateForm">
				<div>
					카테고리 : <select name="newbcno" class="newbcno">
									<option value="1">공지사항</option>
									<option value="2">자유게시판</option>
									<option value="3">노하우</option>
								</select>
				</div>
				<div>
					제목 : <input type="text" name="newbtitle" class="newbtitle">
				</div>
				<div>
					내용 : <textarea name="newbcontent" class="newbcontent" rows="" cols=""></textarea>
				</div>
				<div>
					첨부파일 : <input type="file" name="newbfile" class="newbfile">
				</div>
			</form>
			<button onclick="bupdate()" type="button">수정</button>
			<button type="reset">다시쓰기</button>
			<a href="list.jsp"> 목록보기 </a>
		</div>
	</div>
	
	
	<script type="text/javascript" src="../js/update.js"></script>

</body>
</html>