console.log('login.js실행')


function login(){
	// 1. 입력받은 아이디, 비밀번호 가져옴
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	   $.ajax( { 
       url : "/jspweb/MemberFindController",
       data : {mid : mid, mpwd : mpwd},         // 보내는 데이터
       method : "post",	// get 메소드는 전송하는 date노출(보안취약), post메소드는 전송하는 data노출x(보안)
        success : r =>{ console.log('통신성공')
			if(r){
				location.href = "/jspweb/index.jsp";
			}else{
				document.querySelector('.logincheckbox').innerHTML = '동일한 회원정보가 없습니다.';
			}
		},
        error : e =>{ console.log(e) }
     });

	
	// 2. ajax에게 전달해서 회원이 존재하는지 반환 받는다
		// 2-1 : 로그인성공시 index.jsp이동
		// 2-2 : 로그인실패시 'logincheckbox' 실패 알림
}



/*
		GET, PUT, DELETE vs POST
		
			GET
				- 캐시(기록)
				- 보안취약
				- 추후에 다시 전송시 속도 빠름
				- 매개변수 노출
				- 개인정보 필요없는 데이터(권장)
			
			POST
				- 캐시(기록x)
				- 보안 가능
				- 추후에 다시 전송시 속도 동일
				- 매개변수 노출x
				- 로그인, 회원가입(권장)

*/























