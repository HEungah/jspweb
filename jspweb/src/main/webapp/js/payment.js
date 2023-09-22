console.log('결제페이지')

// 1. 포인트 사용 함수[mno는 서블릿이 가지고있음]
function setPoint(mpamount, mpcomment){
	
	if(loginState == false){return;}
	
	let returnData = false;
	
	$.ajax({
		url : "/jspweb/PointController",
		method : "post",
		async : false,		// ajax가 응답이 올때까지 대기상태 = 동기식
		data : {mpamount : mpamount, mpcomment : mpcomment},
		success : result =>{ console.log(result);
			returnData = result;
		},
		error : e=>{console.log(e);}
		
	})		// ajax end
	
	return returnData;	// ajax 결과를 리턴하는 방식
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

// ------------------- 결제 연동 ---------------------------

// 1. 아임포트 관리자 식별키
IMP.init('imp42785268')

// 2. 결제함수[속성은 결제사 마다 상이]
function requestPay() {
	
		// 2-1 만약에 결제방식을 선택을 안했으면
		if(pay_method == ''){alert('결제방식을 선택해주세요.'); return;}
		if(amount == 0){alert('결제 금액을 선택해주세요.'); return;}
		
		// 2-2 주문번호 만들기
			// 고유성/중복x/PK/식별키
			// 1. 날짜(밀리초)+상품코드+회원번호 조합해서 설계
			// 2. 전화번호+사업자번호 조합해서 설계
			let now = new Date(); console.log(now)
			let time = now.getTime();
			let merchant_uid = time+"-p-"+loginMId; console.log(merchant_uid)
		
	
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method: pay_method,
      merchant_uid: merchant_uid,   // 주문번호
      name: "전동 킥보드",
      amount: amount,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "이젠웹개발",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { 
		if(rsp.success){	// 결제 성공
			
		}else{	// 결제 실패[테스트 : 실패가 성공이라고 가정]
			alert('결제 성공')
			
			// 1. 포인트 적립
			let result = setPoint(amount, '포인트결제');
			// 2. 결제 내역 테이블 기능처리[구현x]
		}
    });
 }


// 3. 결제 방식 선택 함수
let pay_method = '';		// 결제 방식
function onPayMethod(method){
	pay_method = method;
}

// 4. 결제 금액 선택 함수
let amount = 0;	// 결제 금액
function onAmount(value){
	amount = value;
}




















