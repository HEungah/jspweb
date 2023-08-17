package jspweb.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test02")	// @(어노테이션) : 해당 클래스의 URL 매핑
public class Test02 extends HttpServlet {	// HttpServlet 클래스로부터 상속 받으면 해당 클래스는 웹 관련 기능을 제공받는다[ 1. 멀티스레드 2. 예외처리 ... 등등 ]
	private static final long serialVersionUID = 1L;
	// * 자바 서블릿은 HTTP의 기반으로 만들어진 클래스이다
		
	// 브라우저[크롬, 엣지 등] 에서 주소 입력해서 웹사이트 접속하는 방식
	// https://www.naver.com/ ---> get방식
       
    public Test02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 콘솔 출력
		System.out.println("Test02 Hello Js");
		// 2. 웹 출력
		response.getWriter().print("Hello JS");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
