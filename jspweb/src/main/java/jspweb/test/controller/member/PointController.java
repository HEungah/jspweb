package jspweb.test.controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jspweb.test.model.dao.MemberDao;
import jspweb.test.model.dto.MemberDto;
import jspweb.test.model.dto.MpointDto;


@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PointController() {
        super();
 }
    
    // 포인트 사용 함수[증감/차감]
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	UUID uuid = UUID.randomUUID();
    	
    	String mpno = uuid + "";
    	System.out.println(mpno);
    	// 로그인된[세션에 저장된] 회원정보에서 회원번호만 가져오기
    	int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
    	long mpamount = Long.parseLong( request.getParameter("mpamount") );
    	String mpcomment = request.getParameter("mpcomment");
    	System.out.println(mpcomment);
    	
    	MpointDto mDto = new MpointDto(mpno, mno, mpamount, mpcomment,null);
    	
    	boolean result = MemberDao.getInstance().setPoint(mDto);
    	// 응답
    	response.setContentType("application/json;charset=utf-8");
    	response.getWriter().print(result);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		if(type.equals("getPoint")) {
			
			long result = MemberDao.getInstance().getPoint(mno);
			
			json = mapper.writeValueAsString(result);
			
			
		}else if(type.equals("getPointList")) {
			
			List<MpointDto> result = MemberDao.getInstance().getPointList(mno);
			
			json = mapper.writeValueAsString(result);
			
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
