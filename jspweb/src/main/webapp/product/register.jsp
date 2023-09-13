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
			<!-- 제품이미지 : <input type="file"> <br/>  이미지 한개일 때 -->
			제품이미지 : <input name="pimg" type="file" multiple="mlutiple"> <br/>
			
			<button onclick="onRegister()" type="button">등록</button>
		</form>
		
	</div>
	
	<script type="text/javascript" src="/jspweb/js/product/register.js"></script>

</body>
</html>