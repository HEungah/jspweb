console.log('accountbook.js 실행');

// 1. Create(저장)
function inputAccount(){
	
	// 1. HTML input 태그 호출
	let aItemInput = document.querySelector('.aItem');
	let aPaymentInput = document.querySelector('.aPayment');
	let aDateInput = document.querySelector('.aDate');

	// 2. 객체화
		// let 변수명 = {속성명 : 데이터, 속성명 : 데이터}
	let info = {
		aItem : aItemInput.value,
		aPayment : aPaymentInput.value,
		aDate : aDateInput.value
	}	
	console.log(info);
	
	// 3. 유효성검사
	
	// 4. AJAX(HTML에 JQUERY 라이브러리 필수로 호출)
	   $.ajax( { 
       url : "/jspweb/accountbook",
       data : info,         // 보내는 데이터
       method : "post",
       success : function f( result ){
		 	console.log('통신성공');
		 	if(result){
				 alert('저장성공');
				 aread();
				 aItemInput.value='';
				 aPaymentInput.value='';
				 aDateInput.value='';
			 }else{
				 alert('저장실패');
			 }
		},
       error : function f(result){}
     });
	
		// 5. 결과에 따른 코드*/
	
}

aread();
function aread(){	// 실행조건 : JS 열릴때 1번 실행, 등록, 수정, 삭제 => 최신화[화면 새로고침]

	$.ajax( { 
       url : "/jspweb/accountbook",
       data : "",         // 보내는 데이터
       method : "get",
       success : function f( result ){
		   console.log(result);
		   
		   /*응답받은 객체를 html에 출력*/
		   // 1. 출력할 html 구역의 객체 호출
		   let ouput = document.querySelector('.accountBottom');
		   // 2. 반복문을 이용하여 데이터를 html화 시킴
		   let html = ``;
		   	// 리스트내 모든 데이터 출력
		   for(let i = 0; i < result.length; i++){
			   html += `<div class="bottomBox">			
						<div class="bottomItem">${result[i].citem}</div>
			<div class="bottomPayment">${result[i].cpayment}원</div>
			<div class="bottomDate">${result[i].cdate}</div>
			<div class="bottomBtn">
				<button class="mdBtn" onclick="modifyAccount(${result[i].cno})" type="button">수정</button>
				<button class="dtBtn" onclick="deleteAccount(${result[i].cno})" type="button">삭제</button>
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

function modifyAccount(cno){
		// 1. 수정할 내용 입력
	let citem = prompt('수정할 항목 내용');
	let cpayment =prompt('수정할 금액');
	let cdate = prompt('수정할 날짜');
	// 수정시 필요한 데이터 : vno(방문록번호), vcontent(수정할 내용), vpwd(체크할 비밀번호)
		$.ajax( { 
       url : "/jspweb/accountbook",
       data : {cno : cno,citem : citem ,cpayment : cpayment, cdate : cdate},         // 보내는 데이터
       method : "put",
       success : function f( result ){ console.log(result);
       		if(result){
				   alert('수정성공');
				   aread();
			   }else{alert('비밀번호가 일치하지 않습니다.')}
       },
       error : function f(result){}
		   });
}

function deleteAccount(cno){
			$.ajax( { 
       url : "/jspweb/accountbook",
       data : {cno : cno},         // 보내는 데이터
       method : "delete",
       success : function f( result ){ console.log(result);
              	if(result){
				   alert('삭제성공');
				   aread();
			   }else{alert('비밀번호가 일치하지 않습니다.')}
       },
       error : function f(result){}
		   });
}


























