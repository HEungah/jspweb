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

	<div class="webcontainer">
		<h3> 공공데이터 </h3>
		<div>
			<h2> 카카오 지도 </h2>
			<div class="detailbox">
			
			</div>
			<div id="map" style="width:100%;height:400px;"></div>
		</div>
		
		<div>
			<h6> 안산시 착한가격 업소 현황 </h6>
			<table class="apiTable1">
				<tr>
					<th> 번호 </th>
					<th> 상호명 </th>
					<th> 주소 </th>
					<th> 연락처 </th>
					<th> 대표메뉴1 </th>
					<th> 대표메뉴2 </th>
					<th> 대표메뉴3 </th>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 카카오 js -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=73ca70f86f8163f74e44da0971a2f8b5&libraries=clusterer"></script>
	
	<script type="text/javascript" src="/jspweb/js/datago.js"></script>

</body>
</html>