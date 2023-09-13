console.log('제품등록스크립트 실행')
/*
function register(){
	
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData(registerForm);
	
	// 첨부파일없는 폼데이터 전송
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : formData,         // 보내는 데이터
       method : "post",
       contentType : false,
       processData : false,
       success : r => {console.log(r)
       		
			
			
		}
        // error : function f(result){}
     });
	
	
}*/

// 1. 제품 등록
function onRegister(){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	// 2. formData 객체 생성
	let formData = new FormData(registerForm);
	console.log(formData)
	
	$.ajax( { 
       url : "/jspweb/ProductInfoController",
       data : formData,         // 보내는 데이터
       method : "post",
       contentType : false,
       processData : false,
       success : r => {console.log(r)
       		
			
			
		},
        error : function f(result){}
     });
	
}











