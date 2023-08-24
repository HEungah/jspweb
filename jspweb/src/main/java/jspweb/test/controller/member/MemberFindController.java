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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다
		String mid = request.getParameter("mid");
		System.out.println(mid);
		
		// 2. 객체화/유효성검사
		
		// 3. DAO 요청 결과리턴
		boolean result = MemberDao.getInstance().findId(mid);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		// 4. 결과 응답
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
