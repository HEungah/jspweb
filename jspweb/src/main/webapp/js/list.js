console.log('list.js 실행');


/* 게시물 조회 조건 객체 */
let pageObject = { type : 1, bcno : 0, listSize : 10, page : 1,
								key : '', keyword : ''};
	// * type : (1 : 전체조회, 2 : 개별조회)
	// * bcno : 조회할 카테고리 번호[ 기본값은 전체보기]
	// * listSize : 한페이지에 표시될 게시물 수
	// * page : 현재페이지번호
	// * key : 검색분류
	// * keyword : 검색할 내용

// 작성버튼 누르면 실행되는 함수
function onWrite(){
	
	if(loginState == true){
		// - 로그인상태
		location.href = "write.jsp";
		
	}else{
		// - 비로그인상태
		alert('로그인이 필요합니다.');
		
	}
	
}

// 페이지 로드시 게시판출력함수 실행
printBoard(1);

// 게시판 출력 함수
function printBoard(page){
	
	
	pageObject.page = page;
	
	$.ajax( { 
       url : "/jspweb/BoardInfoController",
       data : pageObject,         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       
      		let boardContent = document.querySelector('.boardContent');
			let html = ``;
      		
      		console.log(r.boardList);
      		r.boardList.forEach(b => {
				  html += 
				  `
				  	<tr>
				      <th scope="row" class="bno">${b.bno}</th>
				      <td class="bcname">${b.bcname}</td>
				      <td a class="btitle"><a href="/jspweb/board/view.jsp?bno=${b.bno}">${b.btitle}</a></td>
				      <td class="mid">
				     	 ${b.mid}
				     	 <img class="mimg img-fluid" alt="" src="/jspweb/member/img/${b.mimg}">
				      </td>
				      <td class="bdate">${b.bdate}</td>
				      <td class="bview">${b.bview}</td>
				    </tr>
				  `
				  
			  })
      		
			  boardContent.innerHTML = html;
			  
			  let pagingBox = document.querySelector('.pagingBox');
			  html = ``;
			  
			  html += 
			  `
			  	<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item">
				    	<!-- 이전버튼 -->
				      <a onclick="printBoard(${page <= 1 ? page : page -1})" class="page-link" href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			 `;
			 for(let i = r.startbtn; i <= r.endbtn; i++){
				 // 만약에 현재페이지와 i번째 페이지가 일치하면 버튼태그에 active 속성 추가
				html +=
				 		`
					    <li onclick="printBoard(${i})" class="${page == i ? 'page-item active' : 'page-item'}"><a class="page-link" href="#">${i}</a></li>
					    ` 
				
			 }	 
			html +=
				    `
				    <li class="page-item">
				    	<!-- 다음버튼 -->
				      <a onclick="printBoard(${page >= r.totalpage ? page : page+1})" class="page-link" href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			  `;
			  pagingBox.innerHTML = html;
			  
			  // 게시물수 출력
			  let boardcount = document.querySelector('.boardcount');
			  
			  // 1. 검색이 없을때
			  if(pageObject.key == '' && pageObject.keyword == ''){
				  boardcount.innerHTML = `전체 게시물수 : ${r.totalsize}`;
				  // 2. 검색이 있을때
			  }else{
				  boardcount.innerHTML = `검색된 게시물수 : ${r.totalsize}`;
			  }
			  
		},
       	error : e=>{console.log(e)}
     });
	
	
}	// 게시물 출력함수 end



// 카테고리 클릭했을때
function onCategory(bcno){
	console.log('카테고리 번호 : ' + bcno);
	pageObject.bcno = bcno;
	console.log('오브젝트 카테고리 번호 :' + pageObject.bcno);
	
	// 카테고리 변경시 검색 초기화
	pageObject.key = '';
	pageObject.keyword = '';
	document.querySelector('.cateslc').value = 'b.btitle'
	document.querySelector('.seachinput').value = '';
	
	printBoard(1);
	
}

// 한페이지에 표시할 게시물 갯수변경시 실행함수
function onListSize(){
	
	let listSize = document.querySelector('.selectBtn').value;
	
	pageObject.listSize = listSize;
	
	printBoard(1);
	
}

// 검색 버튼을 클릭했을때
function onSearch(){
	
	// 검색창 분류
	let cateslc = document.querySelector('.cateslc').value;
	// 검색값 입력창
	let seachinput = document.querySelector('.seachinput').value;
 	
 	pageObject.key = cateslc;
 	pageObject.keyword = seachinput;
 	
 	console.log(pageObject.key)
 	console.log(pageObject.keyword)
 	
 	printBoard(1);
}


/*
	HTTP URL에 매개변수(파라미터) 전달 [ 쿼리스트림 방식 ]
		- 형태
			URL ? 변수명=데이터
			URL ? 변수명=데이터&변수명=데이터
			http://localhost:80/jspweb/board/view.jsp?식별변수=${}
		
		- 정의	: 페이지 전환시 매개변수(식별키) 전달
		
		- URL 에서 매개변수 호출
			new URL(location.href).searchParams.get("변수명")
*/























