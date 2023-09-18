<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/product/list.css" rel="stylesheet">

</head>
<body>

	<!-- JSP파일안에 다른 JSP 파일 import 하기 -->
	<%@include file = "../header.jsp" %>
	
	<div class="mapcontent">	<!-- 지도와 사이드바 포함된 구역 -->
		<div id="map" style=""></div>
		
		<!-- 사이드바 구역 -->
		<div class="sidebar">
		
		</div>
	</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=73ca70f86f8163f74e44da0971a2f8b5&libraries=clusterer"></script>
<script type="text/javascript" src="../js/product/list.js"></script>


</body>
</html>