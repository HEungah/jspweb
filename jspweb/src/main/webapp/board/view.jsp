<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/view.css" rel="stylesheet">
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
     />
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="viewWrap position-relative">
		<div class="viewBox container text-start">	<!-- 게시물 출력구역 -->
		
		</div>
		<div class="position-absolute end-0">
			<button class="btn btn-outline-info" onclick="returnList()" type="button">목록보기</button>
		</div>
	</div>
	
	
	<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
	
	<script type="text/javascript" src="../js/view.js"></script>

</body>
</html>