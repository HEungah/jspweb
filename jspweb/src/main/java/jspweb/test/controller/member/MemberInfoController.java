package jspweb.test.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspweb.test.model.dao.MemberDao;
import jspweb.test.model.dto.MemberDto;


@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoController() {
        super();
    }
    
	/* 첨부파일 없을때 회원가입
	 * // 회원가입 protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // 1. AJAX에게 통신받은 data 요청하기
	 * String mid = request.getParameter("mid"); System.out.println("mid : " + mid);
	 * String mpwd = request.getParameter("mpwd"); System.out.println("mpwd : " +
	 * mpwd); String mpwdconfirm = request.getParameter("mpwdconfirm");
	 * System.out.println("mpwdconfirm : " + mpwdconfirm); String memail =
	 * request.getParameter("memail"); System.out.println("memail : " +memail);
	 * String mimg = request.getParameter("mimg"); System.out.println("mimg : "
	 * +mimg);
	 * 
	 * MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg); boolean result
	 * = MemberDao.getInstance().signup(memberDto);
	 * 
	 * response.setContentType("application/json;charset=UTF-8");
	 * response.getWriter().print(result);
	 * 
	 * // 2. 객체화
	 * 
	 * // 3. Dao에게 전달하고 결과를 반환받음
	 * 
	 * // 4. AJAX 통신으로 결과 데이터를 보낸다. }
	 */
    
    // 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String uploadpath = "C:\\Users\\504\\git\\jspweb\\jspweb\\src\\main\\webapp\\member\\img";		// 첨부파일 저장할 경로
    	
    	// 첨부파일 전송 했을때.
    		// 1. 첨부파일 서버PC에 업로드(COS 라이브러리)
    			// MultipartRequest : 파일 업로드 클래스
    		MultipartRequest multi = new MultipartRequest(
    				request,	// 요청방식
    				uploadpath,	// 2. 첨부파일을 저장할 폴더 경로(절대경로)
    				1024*1024*10,		// 3. 첨부파일 용량 허용 범위[ 바이트단위]	10MB
    				"UTF-8",				// 4. 한글인코딩타입
    				new DefaultFileRenamePolicy()	// 5. 만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기
    				);
    		
    		// 2. form 안에 있는 각 데이터 호출
    	
    	// 1. AJAX에게 통신받은 data 요청하기
    		// 일반 input : .getParameter();
    		// 첨부파일 input : .getFilesystemName();
    	String mid = multi.getParameter("mid");	System.out.println("mid : " + mid);
    	String mpwd = multi.getParameter("mpwd"); System.out.println("mpwd : " + mpwd);
    	String memail = multi.getParameter("memail"); System.out.println("memail : " +memail);
    	String mimg = multi.getFilesystemName("mimg"); System.out.println("mimg : " +mimg);
    	
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
