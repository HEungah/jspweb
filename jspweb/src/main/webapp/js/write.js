console.log(loginState);


function bwrite(){console.log('write 함수 실행')
	
// 1. form 가져오기
	let writeInput = document.querySelectorAll('.writeInput')[0];	
	// 2. form 객체화 하기
	let writeData = new FormData(writeInput);
	console.log(writeData);
	
	// 3. ajax로 대용량 form 전송하기
	$.ajax( { 
		       url : "/jspweb/BoardInfoController",
		       data : writeData,         // FormData 객체를 전송
		       contentType : false,
		       processData : false,
		       method : "post",		// 첨부파일 form 전송은 post 방식
		       success : r =>{console.log('통신성공')
					if(r){
						alert('등록성공');
						location.href="/jspweb/board/list.jsp";
					}else{
						alert('등록실패');
					}
				},
       			 error : e=>{console.log(e)}
     		});

}




















