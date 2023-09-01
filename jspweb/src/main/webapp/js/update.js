console.log('update.js 실행');

function bupdate(){console.log('수정함수 실행');

	let updateForm = document.querySelectorAll('.updateForm')[0]
	
	let formData = new FormData(updateForm);
	
	$.ajax( { 
		       url : "/jspweb/BoardInfoController",
		       data : formData,         // FormData 객체를 전송
		       contentType : false,
		       processData : false,
		       method : "put",		// 첨부파일 form 전송은 post 방식
		       success : r =>{console.log('통신성공')
					if(r){
						
					}else{
						
					}
				},
       			 error : e=>{console.log(e)}
     });

	
	
}






















