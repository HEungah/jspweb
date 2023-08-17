console.log('js 실행');

/*
	  $.ajax( { 
      url : ""  ,    // 1. 통신할 경로
      method : "",                               // 2. 통신할 HTTP 메소드 방식 (get, post, put, delete 선택)
      success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
      error : function 결과( result ){ console.log(result); }		// 통신을 실패했을때 반환된 데이터
   		});
	
	success/error : 속성에서 통신 결과의 반환값 받는 함수
	
	서블릿
		- request : 요청 객체
		- response : 응답 객체
			- response.getwriter().print : 데이터 응답( = 웹 출력)
			- response.setContentType("전송할데이터타입명; 인코딩타입") : 출력할 데이터의 타입 혹은 인코딩
				- 1. 문자전송[default]
					response.setContentType("text/html; charset=UTF-8");
				- 2. JSON전송
					response.setContentType("application/json; charset=UTF-8");
		
	JACKSON : JAVA 객체를 JSON 형식에 대한 다양한 클래스 제공 라이브러리				
						
*/


function 예제1(){
	console.log('예제1 함수 실행');
	// ajax 메소드 이용한 서블릿과 통신
	
	$.ajax( { 
    	url : "/jspweb/Test02"  ,    // 1. 통신할 경로
    	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   	});
	
}

function 예제2(){
	console.log('예제2 함수 실행');
	// ajax 메소드 이용한 서블릿과 통신
	
	$.ajax( { 
    	url : "/jspweb/Test03"  ,    // 1. 통신할 경로
    	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   	});
	
}

function 예제3(){
	console.log('예제3 함수 실행');
	// ajax 메소드 이용한 서블릿과 통신
	
	$.ajax( { 
    	url : "/jspweb/Test04"  ,    // 1. 통신할 경로
    	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	success : function 결과( result ){ 
			  console.log(result);
			  console.log(result.title);
			  console.log(result.content);
			  }   // 3. 통신을 성공했을때 반환된 데이터
   	});
	
}

function 예제4(){
	console.log('예제4 함수 실행');
	// ajax 메소드 이용한 서블릿과 통신
	
	$.ajax( { 
    	url : "/jspweb/Test05"  ,    // 1. 통신할 경로
    	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	success : function 결과( result ){ 
			  console.log(result);
			  console.log(result.title);
			  console.log(result.content);
			  }   // 3. 통신을 성공했을때 반환된 데이터
   	});
	
}









