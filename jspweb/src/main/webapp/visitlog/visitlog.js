console.log('js열림');

// 1. Create(저장)
function vwrite(){
	
	// 1. HTML input 태그 호출
	let vwriterInput = document.querySelector('.vwriter');
	let vpwdInput = document.querySelector('.vpwd');
	let vcontentInput = document.querySelector('.vcontent');

	// 2. 객체화
		// let 변수명 = {속성명 : 데이터, 속성명 : 데이터}
	let info = {
		vwriter : vwriterInput.value,
		vpwd : vpwdInput.value,
		vcontent : vcontentInput.value
	}	
	console.log(info);
	
	// 3. 유효성검사
	
	// 4. AJAX(HTML에 JQUERY 라이브러리 필수로 호출)
	   $.ajax( { 
       url : "/jspweb/VisitController",
       data : info,         // 보내는 데이터
       method : "post",
       success : function f( result ){
		 	if(result){
				 alert('저장성공');
				 vread();
				 vwriterInput.value = '';
				 vpwdInput.value = '';
				 vcontentInput.value = '';
			 }else{alert('저장실패');}
		},
       error : function f(result){}
     });
	
		// 5. 결과에 따른 코드
	
}

// 2. Read(호출)
vread();
function vread(){	// 실행조건 : JS 열릴때 1번 실행, 등록, 수정, 삭제 => 최신화[화면 새로고침]

	$.ajax( { 
       url : "/jspweb/VisitController",
       data : "",         // 보내는 데이터
       method : "get",
       success : function f( result ){
		   console.log(result);
		   
		   /*응답받은 객체를 html에 출력*/
		   // 1. 출력할 html 구역의 객체 호출
		   let ouput = document.querySelector('.visit_Bottom');
		   // 2. 반복문을 이용하여 데이터를 html화 시킴
		   let html = ``;
		   	// 리스트내 모든 데이터 출력
		   for(let i = 0; i < result.length; i++){
			   html += `			
			<div class="visitbox"><!-- 방문록 1개의 표시구역 -->
				<div class="visitbox_top">
					<div> ${result[i].vwriter} </div>
					<div class="visitdate"> ${result[i].vdate} </div>
				</div>
				<div class="visitbox_center"> ${result[i].vcontent} </div>
				<div class="visitbox_bottom">
					<button onclick="vupdate(${result[i].vno})" type="button"> 수정 </button>
					<button onclick="vdelete(${result[i].vno})" type="button"> 삭제 </button>
				</div>
			</div>	
			   				`
		   }
		   // 3. 출력객체에 html 형식 대입
		   ouput.innerHTML = html;
		   
	   },
       error : function f(result){}
     });
}

// 3. Update(수정)
function vupdate(vno){console.log('수정함수실행' + vno);
	
	// 1. 수정할 내용 입력
	let vcontent = prompt('수정할 방문록 내용');
	// 2. 비밀번호 일치할 경우에만 수정(비밀번호 체크)
	let vpwd = prompt('방문록 비밀번호');
	
	// 수정시 필요한 데이터 : vno(방문록번호), vcontent(수정할 내용), vpwd(체크할 비밀번호)
		$.ajax( { 
       url : "/jspweb/VisitController",
       data : {vno : vno, vcontent : vcontent, vpwd : vpwd},         // 보내는 데이터
       method : "put",
       success : function f( result ){ console.log(result);
       		if(result){
				   alert('수정성공');
				   vread();
			   }else{alert('비밀번호가 일치하지 않습니다.')}
       },
       error : function f(result){}
		   });
		   
	
}

// 4. Delete(삭제)
function vdelete(vno){console.log('삭제함수실행' + vno);
	
	// 1. 비밀번호가 일치할 경우에 삭제하므로 비밀번호 체크
	let vpwd = prompt('방문록 비밀번호')
	
	// 삭제시 필요한 데이터 : vno(방문록번호), vpwd(체크할 비밀번호)
			$.ajax( { 
       url : "/jspweb/VisitController",
       data : {vno : vno, vpwd : vpwd},         // 보내는 데이터
       method : "delete",
       success : function f( result ){ console.log(result);
              	if(result){
				   alert('삭제성공');
				   vread();
			   }else{alert('비밀번호가 일치하지 않습니다.')}
       },
       error : function f(result){}
		   });
}




















