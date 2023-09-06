<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/write.css" rel="stylesheet">
	
	<!-- 썸머노트 사용하기 위한 부트스트랩css, 썸머노트css -->
	<!-- 부트스트랩 -->
	<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
     />
     <!-- 썸머노트 -->
     <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div id="writeWrap">
		<h3> 글쓰기 페이지 </h3>
		<form class="writeInput position-relative">	<!-- 글쓰기 입력 구역 -->
			<select class="form-select bcno" name="bcno" aria-label="Default select example">
			  <option selected>카테고리</option>
			  <option value="1">공지사항</option>
			  <option value="2">자유게시판</option>
			  <option value="3">노하우</option>
			</select>
			<div class="mb-3">
				<label for="basic-url" class="form-label"> 제목 </label>
  				<input type="text" class="form-control btitle" name="btitle" placeholder="제목" aria-label="제목" aria-describedby="basic-addon2">
			</div>
			<div class="contentInput">
  				<textarea id="summernote" class="bcontent" name="bcontent" aria-label="With textarea"></textarea>
			</div>
			<div class="mb-3">
  				<label class="form-label">첨부파일</label>
  				<input type="file" class="form-control bfile" name="bfile" id="inputGroupFile01">
			</div>
			<div class="position-absolute end-0">
				<button class="btn btn-outline-info" onclick="bwrite()" type="button">등록</button>
				<button class="btn btn-outline-info" type="reset">다시쓰기</button>
				<button class="btn btn-outline-info" onclick="returnList()" type="button">목록보기</button>
			</div>
		</form>
	</div>

	<!-- 썸머노트 사용하기 위한 부트스트랩js, 썸머노트js, 썸머노트 한글js -->
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 부트스트탭 -->
	<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
    
    <!-- 썸머노트 js 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
	
	<!-- 썸머노트 한글적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>

	<script type="text/javascript" src="../js/write.js"></script>
</body>
</html>