// 엔터키 감지
document.addEventListener("keydown", function(event) {
	if (event.isComposing || event.keyCode === 229) return;
    if (event.code === 'Enter' || event.code === 'NumpadEnter') {
        onSend();
    }
});


/*
		1. AJAX	[단방향 통신]
			
			발신자(보내는주체) 	: AJAX		요청
			수신자(받는주체) 		: 서블릿		응답
			
			
			JS							JAVA[서블릿]
		
			AJAX
						rest			get
										post
										put
										delete
										
		2. (웹) 소켓	
			소켓 : 통신의 종착점[도착위치]
			- 전제조건 : 서버가 클라이언트소켓의 정보를 가지고 있어야한다.
			
			WS 프로토콜
		
			JS									JAVA
			[클라이언트소켓]					[서버소켓]
			websocket				
			1. 서버소켓 접속					2. 서버소켓 24시간 상시 클라이언트 소켓 명단 저장					
			3. 데이터 전송					4. 데이터를 받음

*/

/*
		1:1	방식의 채팅구현x
		
				클라이언트[사용자]							서버[서비스회사]
			
			사람1카카오톡
					'안녕'	------------------->
						1. '안녕' 메시지보냄
			사람2카카오톡									
							<-------------------
							3. '안녕' 메시지보냄
															제주도[카카오회사서버]
															- 전제조건 : 클라이언트의 정보를 보관
															접속된명단 : [사람1, 사람2, 사람3, 사람4]							
			사람3카카오톡									2. '안녕' 메시지 받음
							<-------------------
							3. '안녕' 메시지보냄
				
			사람4카카오톡
							<-------------------
							3. '안녕' 메시지보냄
*/


/*// 1. 클라이언트 소켓 만들기

	// 1. JS웹소켓 객체	[ WebSocket클래스]
		// new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓 URL');
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket');	console.log(클라이언트소켓);


	// 2. onopen, onclose, send, onmessage
	
	// 내가 만든 함수를 클라이언트 소켓 속성에 대입
	클라이언트소켓.onmessage = (e) => onmsg(e);

// 2. 연결된 서버소켓에게 메시지 보내기	
function msgsend(){
	// 1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send(msg);	// input에서 입력받은 데이터를 보내기
	document.querySelector('.inputcontent').value = '';
}	// f end

// 3. 연결된 서버소켓으로부터 메시지 받았을때
function onmsg(e){
	console.log(e);
	
	document.querySelector('.contentbox').innerHTML += `<div>${e.data}</div>`

}*/

// ajax(기본값이 비동기 통신)가 응답의 결과를 가지고 오기전에 아래코드 실행[loginState의 값이 변경되기 전에 실행되므로 문제발생]
// ---> 해경방안 : ajax 동기화 통신으로 변경
// 1. 비 로그인 시 입장 불가능
console.log(loginState)
if(loginState == false){alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp";}
console.log('채팅방에 입장한 아이디 : ' + loginMId)

// 2. JS 클라이언트[유저] 소켓 만들기
/*
	JS[HTML파일에 종속되어있는 파일] -> HTML 안에서 실행되는 구조.
	
	*	클라이언트 : 사용 데이터를 요청 하는 PC
		서버 : 데이터 제공하는 PC
		
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수1=데이터1&매개변수2=데이터2...
		2. 경로매개변수 : URL/데이터1/데이터2/데이터3...	
	
	* 소켓이란.
		- 통신의 종착점[데이터의 전달되는 위치]
	
	- WebSocket 웹소켓 라이브러리
		* 소켓 관련된 함수들을 제공하는 클래스
		1. 클라이언트 웹소켓 객체 생성
			new WebSocket("ws://IP주소:PORT번호/프로젝트명/파일명")
		
	*동기화 vs 비동기화
	
	동기화											비동기화[여러 기능을 별도로 처리]
	Client			Sever					Client				Sever
		-----요청1----->							-------요청1----->
	대기상태o			요청1처리중
		<----응답1-----							대기상태x					요청1처리중[5분]
		-----요청2----->							-------요청2----->
						요청2처리중												요청2처리중[1분]
		<----응답1-----							<------응답1-----

*/

let clientSocket = new WebSocket(`ws://localhost:80/jspweb/serversocket/${loginMId}`);
	// 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 -----> 서버소켓의 @OnOpen
	// 서버소켓URL에 매개변수 전달하기(주로 식별자 전달) ---> 서버소켓URL/데이터1/데이터2/데이터3...
	// 메소드 4가지(자동실행)
		// 1. - 클라이언트소켓이 정상적으로 서버소켓에 접속했을때
	clientSocket.onopen = e=>{console.log('서버와 연결됨 ' + e)};
		// 2. - 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때
	clientSocket.onerror = e=>{console.log('서버와 오류발생 ' + e)};
		// 3. - 클라이언트소켓이 서버소켓과 연결이 끊겼을때
	clientSocket.onclose = e=>{console.log('서버와 연결끊김 ' + e)};
		// 4. - 클라이언트소켓이 메시지를 받았을때
	clientSocket.onmessage = e =>onMsg(e);
	





// 3. 서버에게 메시지 전송

// 전송버튼 클릭또는 엔터키 입력시 실행되는 함수
function onSend(){	console.log('전송함수')
	// 3-1 입력값 호출
	let msg =  document.querySelector('.msg').value;
	if(msg == ''){alert('내용을 입력해주세요.'); return;}
	// 3-2 메시지 전송
	clientSocket.send(msg);	// 클라이언트소켓과 연결된 서버소켓에게 메시지 전송	---> 서버소켓의 OnMessage로 이동
	document.querySelector('.msg').value = ``;
}

// 4. 메시지를 받았을때,
function onMsg(e){
	console.log(e);		// e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	
	let msg = JSON.parse(e.data);
		// JSON.parse() : 문자열타입의 JSON형식을 JSON타입으로 변환
		// JSON.stringify() : JSON타입을 문자열 타입으로 변환(JSON형식으로)
	console.log(msg);
	let chatcont = document.querySelector('.chatcont')
	let html = ``;
	
	// 출력할 것
		// 만약 로그인한 사람이 보낸 채팅이면
		console.log(msg.fromMid);
		if(msg.fromMid == loginMId){
			html += `
								<div class="rcont">
									<div class="subcont">
										<div class="date">오전 10:02</div>
										<div class="content">${msg.msg}</div>
									</div>
								</div>`;
		}else{
			html += `
							<div class="lcont">
								<img class="pimg" src="/jspweb/member/img/default.webp"/>
								<div class="tocont">
									<div class="name">${msg.fromMid}</div>
									<div class="subcont">
										<div class="content">${msg.msg}</div>
										<div class="date">오전 10: 10</div>
									</div>
								</div>
							</div>
			`
		}
	
	// 누적 대입[기존 채팅이 존재해야함]
	chatcont.innerHTML += html;
}




















