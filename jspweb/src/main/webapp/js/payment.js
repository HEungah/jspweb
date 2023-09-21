console.log('결제페이지')

setPoint(1000, '회원가입 축하');
// 1. 포인트 사용 함수[mno는 서블릿이 가지고있음]
function setPoint(mpamount, mpcomment){
	if(loginState == false){return;}
	
	$.ajax({
		url : "/jspweb/PointController",
		method : "post",
		data : {mpamount : mpamount, mpcomment : mpcomment},
		success : result =>{ console.log(result)
			
		},
		error : e=>{}
		
	})		// ajax end
	
	
}

// 2. 내 포인트 확인 함수
function getPoint(){
	if(loginState == false){return;}
	
	$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : {type : 'getPoint'},
		success : result =>{ console.log(result)
			
		},
		error : e=>{}
		
	})		// ajax end
	
}

// 3. 내 포인트 내역 전체 출력 함수
function getPointList(){
	if(loginState == false){return;}
	
	$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : {type : 'getPointList'},
		success : result =>{ console.log(result)
			
		},
		error : e=>{}
		
	})		// ajax end
	
}























