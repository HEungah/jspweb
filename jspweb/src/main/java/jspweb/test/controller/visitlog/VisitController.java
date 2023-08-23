package jspweb.test.controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jspweb.test.model.dao.VisitDao;
import jspweb.test.model.dto.VisitDto;


@WebServlet("/VisitController")	// 해당 서블릿(자바) /컨트롤러 클래스를 호출하는 HTTP 주소
public class VisitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisitController() {
        super();
    }
    
    // 1. 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. AJAX의 DATA속성에 있는 객체 정보(속성명이용)를 호출하기
    	String vwriter = request.getParameter("vwriter");		System.out.println(vwriter);
    	String vpwd = request.getParameter("vpwd");	System.out.println(vpwd);
    	String vcontent = request.getParameter("vcontent");	System.out.println(vcontent);
    	
    	// 2. 객체화
    	VisitDto visitDto = new VisitDto(vwriter, vpwd, vcontent);
    	
    	// 3. DAO 객체 전달후 결과 리턴받음
    	boolean result = VisitDao.getInstance().vwriter(visitDto);
    	// 4. 리턴받은 결과를 AJAX에게 리턴
    	//response.setContentType("text/html;charset=UTF-8");	// js에서 "true"(문자열)
    	response.setContentType("application/json;charset=UTF-8");	// js에서 true
    	response.getWriter().print(result);
    	
    }

    // 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청[x] : 모든 글 출력은 조건이 없으므로 요청값 없음.(글번호 필요 x)
		// 2. 객체화[x]
		// 3. DAO
		ArrayList<VisitDto> result = VisitDao.getInstance().vread();
		// 4. 응답
			// js는 ArrayList 타입을 사용할 수 없으므로 ArrayList타입을 JSON 배열로 변환해서 전달해야한다.
			// [ 라이브러리 : jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);	// JSON 타입으로 변환은 불가능하지만 JSON 형식의 문자열로 변환
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);	// 응답은 가능하지만 문자타입으로 전송되므로 객체전송이 불가능
		
	}

	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. AJAX 데이터 요청
		// 2. 객체화
		// 3. Dao 에게 전달후 SQL 결과를 받는다
		// 4. 결과를 AJAX에게 전달한다.
		int vno = Integer.parseInt(request.getParameter("vno")); System.out.println("vno : " + vno);
		String vcontent = request.getParameter("vcontent"); System.out.println("vcontent : " + vcontent);
		String vpwd = request.getParameter("vpwd"); System.out.println("vpwd : " + vpwd);
		
		boolean result = VisitDao.getInstance().vupdate(vno, vcontent, vpwd);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. AJAX 데이터 요청
		// 2. 객체화
		// 3. Dao 에게 전달후 SQL 결과를 받는다
		// 4. 결과를 AJAX에게 전달한다.
		int vno = Integer.parseInt(request.getParameter("vno"));
		String vpwd = request.getParameter("vpwd");
		
		boolean result = VisitDao.getInstance().vdelete(vno, vpwd);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}

/*
 	- HTTP 서블릿 클래스는 기본적으로 get,post,put,delete 함수 제공
 	- 기본 톰캣서버는 get post만 매개변수 전달 가능
 	- put, delete 함수도 매개변수 전달 가능하도록 설정
 	server.xml
 		63줄쯤 원본 코드
 		
 */










