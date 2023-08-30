console.log('hrm.js실행')

function inputHrm(){
	
	// 입력받은 데이터 한번에 가져오기
	let hrmTop = document.querySelectorAll('.hrmTop')[0];
	console.log(hrmTop);
	
	let hrmData = new FormData(hrmTop);
	console.log(hrmData);
	
	$.ajax( { 
		       url : "/jspweb/HrmController",
		       data : hrmData,         // FormData 객체를 전송
		       contentType : false,
		       processData : false,
		       method : "post",		// 첨부파일 form 전송은 post 방식
		       success : r =>{console.log('통신성공')
					if(r){
						alert('등록성공');
						printHrm();
					}else{
						alert('등록실패');
					}
				},
       			 error : e=>{console.log(e)}
     		});
	
}

// 사원정보 출력함수 페이지를 열면 실행
printHrm();
function printHrm(){
	
	$.ajax( { 
       url : "/jspweb/HrmController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       
      		let hrmPrint = document.querySelector('.hrmPrint');
      		
      		let html = ``;
      		
      		for(let i =0; i < r.length; i++){
				  console.log(r[i].himg);
				  html += 
				  `
				  	<tr>
						<td><img class="profile" alt="" src="img/${r[i].himg}"></td>
						<td>${r[i].hname}</td>
						<td>${r[i].hphone}</td>
						<td>${r[i].hposition}</td>
						<td>${r[i].hdate}</td>
					</tr>
				  	
				  `
			  }
			  hrmPrint.innerHTML = html;	
		},
       	error : e=>{console.log(e)}
     });
}

























