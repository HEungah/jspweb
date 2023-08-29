package jspweb.test.controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.test.service.EmailService;


@WebServlet("/AuthSendEmail")
public class AuthSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthSendEmail() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memail = request.getParameter("memail");
		System.out.println(memail);
		
		// 인증번호 생성[난수 6자리]
		String auth = ""; 	// 인증번호를 저장할 문자열
		
		for(int i = 0; i < 6; i++) {
			Random random = new Random();	// 랜덤객체
			auth += random.nextInt(10);		// 랜덤객체.nextInt() : int 타입 범위(0~10)내 난수생성
		}
		
		// 3. 인증번호를 해당 이메일에게 전송 [ SMTP : 간이 우편 전송 프로토콜 ]
			// 이메일 기능 도메인 : 네이버, 다음, 구글
		
			// 메일전송서비스 객체 선언
		EmailService emailService = new EmailService();
			// 객체를 통한 메일전송 함수 호출(받는사람이메일, 인증코드)
		emailService.authsend(memail, auth);
		
		// 인증번호 반환
		response.getWriter().print(auth);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


}


/*
 		- 자바에서 이메일 전송 보내기
 			1. 이메일을 전송할 도메인 필요 [네이버, 다음, 구글 등등]
 				- 네이버 로그인
 					1. 메일
 					2. 메뉴 -> 환경설정
 						IMAP/SMTP 설정 --> 사용함
 						SMTP 서버명 : smtp.naver.com
 			
 			2. SMTP 라이브러리 [이메일 전송에 관련된 클래스/라이브러리 제공]			
 				
  
 */





















