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
	
		<div class="boardtop">
			<h2> 게시판 </h2>
			<p> 다양한 사람들과 정보를 공유하세요 </p>
		</div>
		
		<div class="boardtopetc">
			<button type="button" class="btn btn-outline-success" onclick="onWrite()">글쓰기</button>
			<div>
				<select onchange="onListSize()" class="selectBtn">		<!-- 하나의 페이지에 표시할 최대 게시물수  -->
					<option>10</option>
					<option>15</option>
					<option>20</option>
					<option>3</option>
				</select>
				<span class="boardcount"></span>
			</div>
		</div>
		<!-- 카테고리 구역 -->
		<div class="boardcategorybox">
			<button onclick="onCategory(0)" class="btn btn-outline-info" type="button"> 전체보기 </button>
			<button onclick="onCategory(1)" class="btn btn-outline-info" type="button"> 공지사항 </button>
			<button onclick="onCategory(2)" class="btn btn-outline-info" type="button"> 자유게시판 </button>
			<button onclick="onCategory(3)" class="btn btn-outline-info" type="button"> 노하우 </button>
		</div>
		
		<table class="table caption-top">
			<caption class="tableCaption">글 목록</caption>
		  <thead class="tableHead table-info">
		    <tr>
		      <th scope="col" >게시물번호</th>
		      <th scope="col" >카테고리</th>
		      <th scope="col" class="titleSize">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider boardContent">	<!-- 게시판 내용 출력하는곳 -->

		  </tbody>
	  </table>
	  <div class="boardBottom">
		  <!-- 페이징 처리 -->
		  <div class="pagingBox">
			  
			</div>
			<!-- 검색 구역 -->
			<div class="inputBox">
				<select class="form-select cateslc">	<!-- 검색 키워드 -->
					<!-- value는 sql에서 사용할 필드명 기준 -->
					<option value="b.btitle"> 제목 </option>
					<option value="b.bcontent"> 내용 </option>
					<option value="m.mid"> 작성자 </option>
				</select>
				<input class="form-control seachinput" type="text">	<!-- 검색내용 -->
				<button onclick="onSearch()" class="btn btn-primary btn-sm" type="button"> 검색 </button>
			</div>
		</div>
	</div>
	
	
	<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
	
	<script type="text/javascript" src="../js/list.js"></script>

</body>
</html>