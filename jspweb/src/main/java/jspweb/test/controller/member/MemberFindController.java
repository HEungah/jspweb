package jspweb.test.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.test.model.dao.MemberDao;

@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFindController() {
        super();
    }
    
    // 하나의 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		
		// 2. 객체화/유효성검사
		
		// 3. DAO 요청 결과리턴
		boolean result = MemberDao.getInstance().findIdOrEmail(type, data);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		// 4. 결과 응답
	}
	
	// 로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 매개변수 요청
		
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		// 2. (객체화/유효성검사)
		
		// 3. DAO 에게 전달후 결과 받기
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);	
		
	}

}


















