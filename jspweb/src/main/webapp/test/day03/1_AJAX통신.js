console.log('js실행');

function 예제1(){
	
	$.ajax( { 
    	url : "http://localhost:8080/jspweb/Test06"  ,
    	data : {'value1' : 'jsData'},			// 보내는 데이터
    	method : "get",
     	success : function 결과( result ){
			  console.log('서블릿이 응답한 내용 : ' + result); 
			  }
     	// error
     });
	
}	// f end


function 예제2(){
	// 1. 입력받은 데이터 가져오기
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	
	// 2. 객체화
	let info = {
		name : nameData,
		age : ageData
	}
	
	// 3. 객체를 자바(servlet)에게 전달
	   $.ajax( { 
       url : "http://localhost:8080/jspweb/Text07"  ,
       data : info,         // 보내는 데이터
       method : "get",
        success : function 결과( result ){
			console.log('통신성공');
			}
        // error
     });
	
	
}

























