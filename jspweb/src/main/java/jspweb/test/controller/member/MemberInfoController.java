package jspweb.test.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    	
    	// 개발자 pc 경로 업로드
    	// String uploadpath = "C:\\Users\\504\\git\\jspweb\\jspweb\\src\\main\\webapp\\member\\img";		// 첨부파일 저장할 경로
    	// 서버 pc 경로 업로드
    	// String uploadpath = "C:\\Users\\504\\Desktop\\workclass\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img";
    	// 서버 pc 경로 업로드 (상대경로 => 서버경로 찾아주는 함수)
    		// 서버에 build(배포)된 파일/폴더의 경로 찾기
    	String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
    	System.out.println("member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath);
    	
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
    	
    	// *만약에 사진업로드를 하지 않았으면 기본프로필을 사용하도록 변경 = default.webp
    	if(mimg == null) mimg = "default.webp";
    	
    	MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
    	boolean result = MemberDao.getInstance().signup(memberDto);
    	
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    	// 2. 객체화
    	
    	// 3. Dao에게 전달하고 결과를 반환받음
    	
    	// 4. AJAX 통신으로 결과 데이터를 보낸다.
    }
    
    
    // 회원정보(세션호출) / 로그아웃(세션초기화) 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 [ 기능 구분을 위한 요청 ] 
		String type = request.getParameter("type");
		
		if(type.equals("info")) {
			// 4. 응답
				// 세션에 저장된 로그인객체를 꺼내기
					// 1. 세션호출 [ 세션타입은 Object ]
			Object session = request.getSession().getAttribute("loginDto");
					// 2. 타입변환한다.[ 부 -> 자 (캐스팅/강제타입변환) ] 
			MemberDto loginDto = (MemberDto)session;
			
				// - DTO는 JS가 이해할수 없는 언어 이므로 JS 가 이해할 수 있도록 JS 언어로 변환[jackson 라이브러리]
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(json);
			
		}else if(type.equals("logout")) {
			
			// 세션에 저장된 로그인객체를 초기화
				// 방법1 : 모든 세션 초기화하는 함수
					//request.getSession().invalidate();	// 모든 세션 초기화( 로그인 정보 뿐만아니라 모든 정보 삭제)
				// 방법2 : JVM GC(가비지컬렉터)이용 [해당 객체의 참조를 초기화 ]
					// 삭제할 세션속성명을 null을 참조하게 만듬
				request.getSession().setAttribute("loginDto", null);
			
		}
		
		// 2. 유효성/객체화 ( 없음 )
		
		// 3. Dao 처리 ( 없음 )
		
		
	}
	
	// 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
    	System.out.println("member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath);
    	
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
    		
    		Object session = request.getSession().getAttribute("loginDto");
    		int mno = ((MemberDto)session).getMno();
    		
    		String mimg = multi.getFilesystemName("mimg"); System.out.println("mimg : " +mimg);
    		String mpwd = multi.getParameter("mpwd");
    		String newmpwd = multi.getParameter("newmpwd");
    		
    		// 이미지 수정을 하지 않았을 경우 기존 이미지 그대로 사용
    		if(mimg == null) {
    			mimg = ((MemberDto)session).getMimg();
    		}
    		
    		boolean result = MemberDao.getInstance().updateMember(mno, mimg, mpwd, newmpwd);
    		response.setContentType("application/json; charset=utf-8");
    		response.getWriter().print(result);
	}

	// 회원삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object session = request.getSession().getAttribute("loginDto");
		MemberDto loginDto = (MemberDto)session;
		
		int mno = loginDto.getMno();
		String mpwd = request.getParameter("mpwd");
		
		boolean result = MemberDao.getInstance().deleteMember(mno, mpwd);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
		
	}

}
