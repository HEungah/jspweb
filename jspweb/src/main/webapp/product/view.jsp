<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/product/view.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	
	<%@include file = "../header.jsp" %>
	<div class="webcontent">
		<div class="productBox">
		
			<!-- 캐러셀 -->
			<div>
				<div id="carouselExample" class="carousel slide">
				  <div class="imgbox carousel-inner">
				  
				  </div>
				  <!-- 왼쪽 이동 버튼 -->
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
				  </button>
				  <!-- 오른쪽 이동 버튼 -->
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
				  </button>
				</div>
			</div>	<!-- 캐러셀 end -->
			<div class="mid"></div>
			<div class="categorydate">
				<div class="pcname"></div>
				<div class="pdate"></div>
			</div>
			<div class="pname"></div>
			<div class="pprice"></div>
			<div class="pcontent"></div>
			<div class="etcbtnbox">
				<button type="button">찜하기♡</button>
				<button type="button">바로구매</button>
			</div>
			
			<!-- 탭스 스타트 -->
				<!-- 탭목록 -->
			<ul class="my-5 nav nav-tabs nav-pills nav fill" id="myTab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#navTap1" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">제품위치</button>
				  </li>
				  <li class="nav-item" role="presentation">	<!-- 베품내용 -->
				    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#navTap2" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">제품후기</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#navTap3" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">Qna</button>

				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="disabled-tab" data-bs-toggle="tab" data-bs-target="#navTap4" type="button" role="tab" aria-controls="disabled-tab-pane" aria-selected="false">구매 유의사항</button>
				  </li>
				</ul>
					<!-- 탭 내용 -->
				<div class="tab-content" id="myTabContent">
				  <div class="tab-pane fade show active" id="navTap1" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
				  	제품위치 출력되는 구역
				  </div>
				  <div class="tab-pane fade" id="navTap2" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
				  	제품후기 출력되는 구역
				  </div>
				  <div class="tab-pane fade" id="navTap3" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">
				  	Qna 출력되는 구역
				  </div>
				  <div class="tab-pane fade" id="navTap4" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">
				  	구매유의사항 출력되는 구역
				  </div>
				</div>
			
		</div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/product/view.js"></script>
	
</body>
</html>