<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/product/wishlist.css" rel ="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="container">	<!--부트스트랩 : container 디바이스 크기에 따른 반응형 구역 -->
		<h3 class="title"> 찜 목록 리스트</h3>
		<table class="wishList table table-hover align-middle text-center">	<!-- bs 테이블 -->
			<tr>
				<th width="5%"><input class="checkbox" type="checkbox"></th>
				<th width="6%">이미지</th>
				<th width="40%">제품 정보</th>
				<th width="10%">가격</th>
				<th width="10%">비고</th>
				<th width="10%">삭제</th>
			</tr>
			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td><img src="/jspweb/member/img/default.webp" width="80%"></td>
				<td>킥보드 팝니다</td>
				<td>800,000</td>
				<td></td>
				<td><button type="button">x</button></td>
			</tr>
			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td><img src="/jspweb/member/img/default.webp" width="80%"></td>
				<td>킥보드 팝니다</td>
				<td>800,000</td>
				<td></td>
				<td><button type="button">x</button></td>
			</tr>
		</table>		
		<div class="selectbtn">
			<button class="btn btn-danger" type="button">선택 삭제</button>
			<button class="btn btn-danger" type="button">전체 삭제</button>
		</div>
		<div class="buybtn">
			<button class="btn btn-success" type="button">선택 구매</button>
			<button class="btn btn-success" type="button">전체 구매</button>
		</div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/product/wishlist.js"></script>

</body>
</html>