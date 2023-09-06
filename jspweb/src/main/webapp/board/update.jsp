<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/update.css" rel="stylesheet">
	<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
     />
     <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div id="updateWrap">	<!-- 수정페이지 전체화면 -->
		<div class="updateBox">
			<form class="updateForm position-relative">	<!-- 글쓰기 입력 구역 -->
			<select class="form-select newbcno" name="newbcno" aria-label="Default select example">
			  <option selected>카테고리</option>
			  <option value="1">공지사항</option>
			  <option value="2">자유게시판</option>
			  <option value="3">노하우</option>
			</select>
			<div class="mb-3">
				<label for="basic-url" class="form-label"> 제목 </label>
  				<input type="text" class="form-control newbtitle" name="newbtitle" placeholder="제목" aria-label="제목" aria-describedby="basic-addon2">
			</div>
			<div class="contentInput">
  				<textarea id="summernote" class="newbcontent" name="newbcontent" aria-label="With textarea"></textarea>
			</div>
			<div class="mb-3">
  				<label class="form-label">첨부파일</label>
  				<input type="file" class="form-control newbfile" name="newbfile" id="inputGroupFile01">
			</div>
			<div class="position-absolute end-0">
				<button class="btn btn-outline-info" onclick="bupdate()" type="button">수정</button>
				<button class="btn btn-outline-info" type="reset">다시쓰기</button>
				<button class="btn btn-outline-info" onclick="returnList()" type="button">목록보기</button>
			</div>
		</form>
		</div>
	</div>
	
	<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
    
    <!-- 썸머노트 js 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
	
	<!-- 썸머노트 한글적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	<script type="text/javascript" src="../js/update.js"></script>

</body>
</html>