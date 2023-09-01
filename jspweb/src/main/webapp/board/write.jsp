<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/write.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div>
		<h3> 글쓰기 페이지 </h3>
		<form class="writeInput">	<!-- 글쓰기 입력 구역 -->
			카테고리 : <select name="bcno" class="bcno">
							<option value="1">공지사항</option>
							<option value="2">자유게시판</option>
							<option value="3">노하우</option>
						</select>
			제목 : <input type="text" name="btitle" class="btitle">
			내용 : <textarea name="bcontent" class="bcontent" rows="" cols=""></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile">
			<button onclick="bwrite()" type="button">등록</button>
			<button type="reset">다시쓰기</button>
			<a href="list.jsp"> 목록보기 </a>
		</form>
	</div>

	<script type="text/javascript" src="../js/write.js"></script>
</body>
</html>