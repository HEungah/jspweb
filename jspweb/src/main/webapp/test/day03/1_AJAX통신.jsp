<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> AJAX [ JS ---- 자바[서블릿] 통신 ]</h3>
	<h6> 1. JS 에서 servlet[자바웹클래스]에게 통신하고 데이터 보내기 </h6>
	<button onclick="예제1()" type="button">예제1</button>
	
	<h6> 1. [HTML에서 입력받은] JS 에서 servlet[자바웹클래스]에게 통신하고 데이터 보내기 </h6>
	성명 : <input class="name" type = "text"> <br>
	나이 : <input class="age" type = "text"> <br>
	<button onclick="예제2()" type="button">예제2</button>
	
	
	<!-- 최신 JQUERY 라이브러리 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="1_AJAX통신.js" type="text/javascript"></script>

</body>
</html>