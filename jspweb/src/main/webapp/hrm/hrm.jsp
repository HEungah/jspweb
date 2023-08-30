<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="..\css\hrm.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div id="hrmWrap">
		<div class="hrmBox">
			<div class="hrmTitle">인사정보입력</div>
			<form class="hrmTop">
				<div class="inputBox">
					<label for="implopic" class="label">직원사진</label>
					<input name="himg" class="himg" type="file">
				</div>
				<div class="inputBox">
					<label for="imploname" class="label">직원명</label>
					<input name="hname" class="hname" type="text">
				</div>
				<div class="inputBox">
					<label for="implophone" class="label">직원전화번호</label>
					<input name="hphone" class="hphone" type="text">
				</div>
				<div class="inputBox">
					<label for="imploname" class="label">직급</label>
					<select name="hposition" class="hposition">
						<option>사장</option>
						<option>부장</option>
						<option>팀장</option>
						<option>대리</option>
						<option>주임</option>
						<option>사원</option>
					</select>
				</div>
			</form>
			<button onclick="inputHrm()" class="inputBtn" type="button">등록</button>
		</div>
		<div class="hrmBottom">
			<table class="hrmTable">
				<thead class="hrmTableHead">
					<tr>
						<th class="tableTh">사진</th>
						<th class="tableTh">이름</th>
						<th class="tableTh">전화번호</th>
						<th class="tableTh">직급</th>
						<th class="tableTh">등록일</th>
					</tr>
				</thead>
				<tbody class="hrmPrint">	<!-- 인사정보 출력할 구역 -->

				</tbody>
			</table>
		</div>
	</div>
	
	
	

	
	<script type="text/javascript" src="../js/hrm.js"></script>

</body>
</html>