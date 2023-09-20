console.log('찜목록 리스트')


if(loginState == false){location.href="/jspweb/member/login.jsp";}

printWishList();
let checkIndex = [];	// 현재 체크된 인덱스
function printWishList(){
	
	$.ajax({
		url : "/jspweb/PwishListController",
		async : false,
		data : {type : 'findByAll'},
		method : "get",
		success : jsonArray =>{console.log(jsonArray);
			
			let wishList = document.querySelector('.wishList')
			let html = 
			`
				<tr>
					<th width="5%"><input class="checkbox" type="checkbox"></th>
					<th width="6%">이미지</th>
					<th width="40%">제품 정보</th>
					<th width="10%">가격</th>
					<th width="10%">비고</th>
					<th width="10%">삭제</th>
				</tr>
			`;
			
			jsonArray.forEach(p=>{
				
				html += 
				`
					<tr>
						<td><input class="checkbox" type="checkbox"></td>
						<td><img src="/jspweb/product/img/${Object.values(p.imgList)[0]}" width="80%"></td>
						<td>${p.pname}</td>
						<td>${p.pprice.toLocaleString()}원</td>
						<td></td>
						<td><button onclick="deleteWish(${p.pno})" type="button">x</button></td>
					</tr>
				`
				
			})
			
			
			wishList.innerHTML = html;
			
		}
		
	})
	
}	// f end

// x버튼을 눌렀을때 개별삭제
function deleteWish(pno){
	
	$.ajax({
		url : "/jspweb/PwishListController",
		async : false,
		data : {pno : pno},
		method : "delete",
		success : result =>{console.log(result);
			if(result){
				console.log('삭제완료')
				printWishList();
			}
		}
		
	})
		
}

// 0. 제품목록에서의 선택상자 모두 체크기능
	// 1. 모든 checkbox 가져오기
	let checkList = document.querySelectorAll('.checkbox');
		console.log(checkList)
	// 2. 첫번째 체크박스 클릭 이벤트
		// dom객체명.addEventListener('이벤트명', (이벤트결과매개변수)=>{})
	checkList[0].addEventListener('click', (e)=>{
		console.log('첫번째 체크박스 클릭')
		console.log(checkList[0].checked)
		// 3. 만약에 첫번째 체크박스가 체크 되면 모든 체크박스는 체크 활성화
		if(checkList[0].checked == true){
			checkList.forEach((check)=>{check.checked = true})
		}else{
			checkList.forEach((check)=>{check.checked = false})
		}
	})	
































