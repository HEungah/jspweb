package jspweb.test.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	// 1. 필드
	private String fromEmail = "보내는사람이메일";		// 관리자 이메일
	private String fromEmailPwd = "이메일비밀번호";	// 보내는 사람의 이메일 주소 비밀번호
	// 2. 생성자
	public EmailService() {
	}
	
	// 3. 메소드
		// 1. 이메일 보내기 함수
	public boolean authsend(String toEmail, String contentHTML) {	// 이메일 전송에 관련된 클래스
		
		// 1. 호스팅 설정[네이버 기준]
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.naver.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		// 2. 인증처리 [ 네이버에 보내는 사람의 정보 체크]
		
			// 인증할 객체
		Authenticator authenticator = new Authenticator() {
			
			// 패스워드 검증 함수 오버라이드하여 구현
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromEmailPwd);
			}
			
		};
			// Authenticator : import javax.mail.Authenticator;
			// getPasswordAuthentication(return new PasswordAuthentication(보내는사람이메일, 보내는사람이메일패스워드))
		
		Session session = Session.getDefaultInstance( properties, authenticator);
			// import javax.mail.Session
			// .getDefaultInstance(호스트설정Properties, 인증할 계정정보)
			// session : 인증후 결과정보를 담고 있는 객체
		
		// 3. 메일 전송
			// Mime 프로토콜 : smtp가 보낼수 있는 표준 형식/포맷
			// 1. MimeMessage 객체 생성
			// 2. .setFrom(new InternetAddress(보내는 사람의 이메일주소))
			// 3. .addRecipient(Message.RecipientType.TO, 받는 사람의 이메일주소)
			// 4. .setSubject("메일제목")
			// 5. .setText("메일내용")
			// 6. Transport.send(MimeMessage객체)
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("Ezen JSP 회원가입 인증코드 발송");
			message.setText("이메일 인증코드 : " + contentHTML);
			Transport.send(message);
			
			return true;
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}



















