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


// 1. 클라이언트 소켓 만들기

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
	
	
}
















