

/*
	onchange : 포커스(커서) 변경될때 값이 다르면
	onkeyup : 키보드에서 키를 누르고 때었을때
	onkeydown : 키보드에서 키를 눌렀을때
*/

/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어
		문법
			/^ 		: 정규표현식 시작 알림.
			$/			: 정규표현식 끝 알림.
			[a-z]		: 소문자 a-z 패턴 검색
			[A-Z]	: 대문자 A-Z 패턴 검색
			[0-9]	: 숫자 0~9 패턴 검색
			\d			: 숫자 0~9 패턴 검색
			[가-힣]	: 한글 패턴 검색
			{ 최소길이, 최대길이}	: 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개 이상 반복
			- : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 알에 있는 패턴 0개 반복
			
			예시]
				1. [a-z]		: 소문자 검색
				2. [a-zA-Z]	: 영문(대,소) 검색
				3. [a-zA-Z0-9]	: 영문 + 숫자 조합 검색
				4. [a-zA-Z0-9가-힣]	: 영문 + 숫자 + 한글 조합 패턴
				5. [abcdef]	: abcdef 패턴
				6. (?=.*[패턴문자]) : 해당 패턴문자가 한개 이상 포함된 패턴
						(?=.*[a-z]) : 소문자 한개 이상 필수 입력
						(?=.*[A-Z]) : 대문자 한개 이상 필수 입력
						(?=.*[0-9]) : 숫자 한개 이상 필수 입력
						(?=.*[\d]) : 숫자 한개 이상 필수 입력
						(?=.*[!@#$...&*]) : 패턴문자내 특수문자 한개 이상 필수
						
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
				영대문자1개 +  영소문자1개 + 숫자 1개 이상 필수로 갖는 5~20글자 사이 
						
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%&^*])[A-Za-z0-9]{5,20}$/
				영대문자1개 +  영소문자1개 + 숫자 1개 + 특수문자 1개 이상필수로 갖는 5~20글자 사이 
				
				/^[a-z0-9{5,30}]$/ 영문소문자, 숫자, 5~30길이
				
			패턴 검사
			"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true/ 아니면 false
				
*/

function idcheck(){	/*실행조건 : 아이디 입력창에 입력할때마다*/

	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheck =  document.querySelector('.idcheckbox');
	// 2. 유효성검사
		// 1. 글자수
		//if(mid.length < 5 && mid.length > 30){}
			// 1. 정규표현식 작성
	let midj = /^(?=.*[a-z])[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사
	console.log(midj.test(mid));	
	if(midj.test(mid)){	// 입력한 값이 패턴과 일치하면
		
		// 입력한 아이디가 패턴과 일치하면 아이디 중복검사 실행
	$.ajax( { 
       url : "/jspweb/MemberFindController",
       data : {type : "mid", data : mid},         // 보내는 데이터
       method : "get",
        success : r =>{console.log('유효성함수실행')
			if(r){
				idcheck.innerHTML = '사용중인 아이디입니다.';
			}else{
				idcheck.innerHTML = '사용할 수 있는 아이디입니다.';
			}
			
		}
        // error : r =>{}
     });
     
	}else{	// 입력한 값이 패턴과 일치하지 않으면
		idcheck.innerHTML = '영문(소문자)+숫자 조합의 5~30글자만 가능합니다.';
	}
	
	
} // idcheck() end

// 비밀번호 유효성검사[1. 정규표현식 검사 2. 비밀번호와 비밀번호확인 일치여부]
function pwcheck(){console.log('pw 유효성검사');

	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	// 1. 입력값 호출
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	
	// 2. 유효성 검사
		// 1. 정규표현식 만들기
	let mpwj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/;
		// 대소문자 영어 1개이상 + 숫자 1개 이상 5~20글자 사이
	
	if(mpwj.test(mpwd)){	// 정규표현식 확인
		// 비밀번호 확인 정규표현식 검사
		if(mpwj.test(mpwdconfirm)){
			// 비밀번호 와 비밀번호확인 일치여부
			if(mpwd == mpwdconfirm){
				pwcheckbox.innerHTML = `사용가능한 비밀번호`;				
			}else{
				pwcheckbox.innerHTML = `비밀번호화 비밀번호확인의 값이 다릅니다.`
			}
		}else{
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
		}
		
	}else{
		console.log('정규표현식 실패');
		pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
	}
}	// pwcheck() end

function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	
	// 1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;
	
	// 2. 이메일 정규표현식[ 이메일 앞부분 (@기준)]
		// 1. 이메일 앞부분 : 영대소문자,숫자,_-
		// 2. +@ 		: @앞에 패턴이 1개이상 필수
		// 3. 도메인
				// 회사명 : @ 뒤에, 영대소문자,숫자,_-
				// . : +\. (앞에 패턴이 1개이상 필수)
				// 도메인(com, kr, co...) : . 뒤에 a-zA-Z
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/;
	
	if(memailj.test(memail)){
		
		$.ajax( { 
	       url : "/jspweb/MemberFindController",
	       // type 사용하는 이유 : 서로 다른 ajax가 동일한 서블릿과 동일한 get메소드 사용하기 위해
	       data : {type : "memail", data : memail},         // 보내는 데이터
	       method : "get",
	        success : r =>{console.log('유효성함수실행')
				if(r){
					emailcheckbox.innerHTML = `사용중인 이메일입니다.`
					document.querySelector('.authReqBtn').disabled = true;					
				}else{
					emailcheckbox.innerHTML = `사용가능한 이메일입니다.`	
					document.querySelector('.authReqBtn').disabled = false;			
				}
				
			}
	        // error : r =>{}
	     });
	}else{
		emailcheckbox.innerHTML = `이메일형식에 맞게 입력해주세요.`	
		document.querySelector('.authReqBtn').disabled = true;							
	}
}


function signup(){
	
	// 1. HTML에 가져올 데이터의 tag 객체 호출[ DOM객체 ]
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let memailInput = document.querySelector('.memail');
	let mimgInput = document.querySelector('.mimg');
	
	// 2. 객체화
	let info = {
		mid : midInput.value,
		mpwd : mpwdInput.value,
		mpwdconfirm : mpwdconfirmInput.value,
		memail : memailInput.value,
		mimg : mimgInput.value
	}
	
	// 3. 유효성검사
	
	// 4. AJAX메소드를 이요한 JAVA와 통신
	 $.ajax( { 
       url : "/jspweb/MemberInfoController",
       data : info,         // 보내는 데이터
       method : "post",
        success : r =>{console.log('통신성공')
			if(r){
				alert('회원가입성공')
				midInput.value = "";
				mpwdInput.value = "";
				mpwdconfirmInput.value = "";
				memailInput.value = "";
				mimgInput = "";
			}else(alert('회원가입실패'))
		}
        // error : r=>{}
     });
	
	
		// 5. Servlet의 응답에 따른 제어
}

// 이메일 인증요청버튼을 눌렀을때 실행되는 함수
function authRequest(){console.log('이메일 인증요청')
	
	let authbox = document.querySelector('.authbox')
	let html = 
								`
		<input class="ecord" type="text">
		<button onclick="auth()" type="button">인증</button>
		<span class="timebox"></span><br/>
		`
	authbox.innerHTML = html;	
	
	// 타이머 실행
	authcode = '1234';	// 인증코드 '1234' --> 테스트용
	timer = 10;		// 인증타이머 --> 테스트용
	setTimer();		// 타이머실행
	
}

// -------------------- 인증요청 변수 -------------------

let authcode = '';
let timer = 0;	// 인증 시간 변수
let timerInter;	// setInterval() 함수를 가지고 있는 변수

// ---------------------------------------------------

// 타이머 함수
function setTimer(){
	// setInterval(함수명, 실행간격[밀리초])
	timerInter = setInterval( () => {
		// 시간 형식 만들기
			// 1. 분 만들기
		let m = parseInt(timer/60);	// 분 계산
		let s = timer % 60; // 초 계산 [나머지]
			// 2. 두 자리수 맞춤 3 -> 03
		m = m < 10 ? "0"+m : m;
		s = s < 10 ? "0"+s : s;
		
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`
		timer--;	// 1씩 차감
		
		// 만약에 타이머가 0이면 [시간 끝]
		if(timer < 0){
			// 1. setInterval 종료[ 누구를 종료시킬껀지 식별자(변수) 필요]
			clearInterval(timerInter);
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = `인증실패`;
			// 3. authbox 다시 숨기기
			document.querySelector('.authbox').innerHTML = ``;
		}
		
	}, 1000  );
}


function auth(){
	
	// 1. 입력받은 인증코드
	let ecord = document.querySelector('.ecord').value;
	
	// 2. 비교[ 인증코드와 입력받은 인증코드 ]
	if(authcode == ecord){
		// 1. setInterval 종료
		clearInterval(timerInter);
		// 2. 인증성공을 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증성공`;
		// 3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML = ``;
	}else{
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증코드불일치`;
	}
}






















