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
	
		<h3>제품 등록 페이지</h3>
		<!-- <form class="registerForm">
			제품명 : <input name="pname1" type="text">	<br>
			제품설명 : <textarea name="pcontent1"></textarea>	<br>
			<button onclick="register()" type="button">등록</button>
			
		</form> -->
		<form class="registerForm">
			카테고리 :	<select name="pcno">
							<option value="1">노트북</option>
							<option value="2">태블릿</option>
							<option value="3">스마트폰</option>
						</select> <br/>
			제품명 :	<input name="pname" type="text"> <br/>
			제품설명 : <textarea name="pcontent"></textarea> <br/>
			제품가격 : <input name="pprice" type="number"> <br/>
			제품장소 : <div id="map" style="width:100%;height:350px;"></div>
			<div id="clickLatlng"></div>
			<!-- 제품이미지 : <input type="file"> <br/>  이미지 한개일 때 -->
			<!-- commons.jar 라이브러리 사용 -->
			<!-- 제품이미지 : <input name="pimg" type="file" multiple="mlutiple"> <br/> -->
			
			<!-- 드래그앤드랍으로 이미지 올리기 -->
			<div class="fileDropBox" style="width: 300px; height:150px; border:1px solid red">
				여기에 드래그해서 파일을 올려주세요.
				
			</div>
			
			<button onclick="onRegister()" type="button">등록</button>
		</form>
		
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=73ca70f86f8163f74e44da0971a2f8b5"></script>
	
	<script type="text/javascript" src="/jspweb/js/product/register.js"></script>

</body>
</html>