package jspweb.test.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.test.model.dao.MemberDao;
import jspweb.test.model.dto.MemberDto;


@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoController() {
        super();
    }
    
    // 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. AJAX에게 통신받은 data 요청하기
    	String mid = request.getParameter("mid");	System.out.println("mid : " + mid);
    	String mpwd = request.getParameter("mpwd"); System.out.println("mpwd : " + mpwd);
    	String mpwdconfirm = request.getParameter("mpwdconfirm"); System.out.println("mpwdconfirm : " + mpwdconfirm);
    	String memail = request.getParameter("memail"); System.out.println("memail : " +memail);
    	String mimg = request.getParameter("mimg"); System.out.println("mimg : " +mimg);
    	
    	MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
    	boolean result = MemberDao.getInstance().signup(memberDto);
    	
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    	// 2. 객체화
    	
    	// 3. Dao에게 전달하고 결과를 반환받음
    	
    	// 4. AJAX 통신으로 결과 데이터를 보낸다.
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
