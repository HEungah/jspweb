

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
				idcheck.style.color = "red";
				checkList[0] = false;
			}else{
				idcheck.innerHTML = '사용할 수 있는 아이디입니다.';
				idcheck.style.color = "#43E300";
				checkList[0] = true;
			}
			
		}
        // error : r =>{}
     });
     
	}else{	// 입력한 값이 패턴과 일치하지 않으면
		idcheck.innerHTML = '영문(소문자)+숫자 조합의 5~30글자만 가능합니다.';
		idcheck.style.color = "red";
		checkList[0] = false;
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
				pwcheckbox.style.color = "#43E300";	
				checkList[1] = true;
			}else{
				pwcheckbox.innerHTML = `비밀번호화 비밀번호확인의 값이 다릅니다.`
				pwcheckbox.style.color = "red";
				checkList[1] = false;
			}
		}else{
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
			pwcheckbox.style.color = "red";
			checkList[1] = false;
		}
		
	}else{
		console.log('정규표현식 실패');
		pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
		pwcheckbox.style.color = "red";
		checkList[1] = false;
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
					emailcheckbox.style.color = "red";
					document.querySelector('.authReqBtn').disabled = true;
					checkList[2] = false;					
				}else{
					emailcheckbox.innerHTML = `사용가능한 이메일입니다.`
					emailcheckbox.style.color = "#43E300";	
					document.querySelector('.authReqBtn').disabled = false;
					checkList[2] = false;			
				}
				
			}
	        // error : r =>{}
	     });
	}else{
		emailcheckbox.innerHTML = `이메일형식에 맞게 입력해주세요.`
		emailcheckbox.style.color = "red";	
		document.querySelector('.authReqBtn').disabled = true;
		checkList[2] = false;								
	}
}


/*// 유효성검사 x 회원가입
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
}*/

// 이메일 인증요청버튼을 눌렀을때 실행되는 함수
function authRequest(){console.log('이메일 인증요청')

	
	// 테스트용
	let authbox = document.querySelector('.authbox')
	let html = 
								`
		<input class="ecord" type="text">
		<button onclick="auth()" type="button">인증</button>
		<span class="timebox"></span><br/>
		`
	authbox.innerHTML = html;	
	
	// 타이머 실행
	authcode = "1234";	// 인증코드 '1234' --> 테스트용 // controller에게 전달받은 값
	timer = 120;		// 인증타이머 --> 테스트용
	setTimer();		// 타이머실행


/*	// -- 인증요청시 서블릿 통신 [인증코드 생성, 이메일 전송]
	$.ajax( { 
       url : "/jspweb/AuthSendEmail",
       data : {memail : document.querySelector('.memail').value},         // 보내는 데이터
       method : "get",
        success : r =>{console.log(r)
			let authbox = document.querySelector('.authbox')
			let html = 
										`
				<input class="ecord" type="text">
				<button onclick="auth()" type="button">인증</button>
				<span class="timebox"></span><br/>
				`
			authbox.innerHTML = html;	
			
			// 타이머 실행
			authcode = r;	// 인증코드 '1234' --> 테스트용 // controller에게 전달받은 값
			timer = 120;		// 인증타이머 --> 테스트용
			setTimer();		// 타이머실행
        	
        },
        error : r =>{console.log(r)}
     });*/
	
	
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
			checkList[2] = false;
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
		checkList[2] = true;
	}else{
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증코드불일치`;
		checkList[2] = false;
	}
}

// 7. 첨부파일에 사진 등록시 등록 사진을 HTML으로 표시하기(등록된사진 미리보기 용도)
function preimg(object){console.log('사진미리보기');
	console.log(object);	// 이벤트 발생시킨 태그의 DOM 객체를 인수로 받음(this)
	
	// 1. input 태그의 속성[type, class, onchange, name...]
	// 1. input 태그 이면서 type="file"이면 추가적인 속성 사용 가능
		// .files : input type="file" 에 선택한 파일 정보를 리스트로 받음
	console.log(object.files[0]);	// 리스트 중에서 하나의 파일만 가져오기
	
	// ---- 해당 파일을 바이트코드로 변환
	// 2. JS 파일클래스 선언
	let file = new FileReader();		// 파일 읽기 클래스를 이용한 파일읽기객체 선언
	
	// 3. 파일 읽어오기 함수 제공
	file.readAsDataURL(object.files[0]);		// input 에 등록된 파일리스트중 1개를 파일객체로 읽어옴
	
	// 4. 읽어온 파일을 해당 html img 태그에 load
	file.onload = e =>{
			// 읽어온 파일의 바이트코드를 img src속성에 대입
			document.querySelector('.preprofile').src = e.target.result;
		}
	
}

let checkList = [false, false, false];	// [0] : 아이디통과여부, [1] : 비밀번호통과여부, [2] : 이메일통과여부
// 8. 회원가입 메소드
function signup(){
	
	// 1. 아이디/비밀번호/이메일 유효성검사 통과 여부 체크
	console.log(checkList);
	if(checkList[0] && checkList[1] && checkList[2]){
		console.log('회원가입 진행가능')
		
		// 2. 입력받은 데이터를 한번에 가져오기( form 태그 이용 )
			// <form>각종 input/button</form> 
			// 1. form 객체 호출
			let signupForm = document.querySelectorAll('.signupForm')[0];
			console.log(signupForm);
			// 2. form 데이터 객체화 => ajax json형식으로 전송필요
				// 일반객체로 첨부파일 전송x -> FormData객체 이용시 첨부파일 전송 가능
			let signupData = new FormData(signupForm);	// 첨부파일시 필수[대용량 데이터]
			console.log(signupData);
			
			// 3. AJAX 에게 첨부파일[대용량] 전송 하기
				// 첨부파일이 있을시 [ 기본 json 형식의 전송x form 객체 타입으로 변환]
			$.ajax( { 
		       url : "/jspweb/MemberInfoController",
		       data : signupData,         // FormData 객체를 전송
		       contentType : false,
		       processData : false,
		       method : "post",		// 첨부파일 form 전송은 post 방식
		        success : r =>{console.log('통신성공')
		        	if(r){		// 회원가입성공 알림, 페이지전환
						alert('회원가입성공');
						location.href = '/jspweb/member/login.jsp';
					}else{
						alert('회원가입실패');
					}
				},
       			 error : e=>{console.log(e)}
     		});
     		
	}else{
		alert('정상적으로 입력되지 않은 내용이 있습니다.');
	}
}























