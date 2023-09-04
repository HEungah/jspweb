<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
	
	<link href="../css/list.css" rel = "stylesheet">
	<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
     />
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="BoardWrap">	<!-- 게시판 전체구역 -->
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col" >게시물번호</th>
		      <th scope="col" >카테고리</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider boardContent">	<!-- 게시판 내용 출력하는곳 -->

		  </tbody>
		</table>
		<button type="button" class="btn btn-outline-info" onclick="onWrite()">글쓰기</button>
	</div>
	
	
	<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
	
	<script type="text/javascript" src="../js/list.js"></script>

</body>
</html>