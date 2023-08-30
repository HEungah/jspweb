package jspweb.test.controller.hrm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspweb.test.model.dao.HrmDao;
import jspweb.test.model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HrmController() {
        super();

    }
    
    // 인사정보가져오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<HrmDto> result = HrmDao.getInstance().hread();
		
		// 리턴값을 JSON 형식으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	
	
	// 인사정보등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
		System.out.println("hrm 폴더 img 폴더 실제(서버) 경로 : " + uploadpath);
		
		// 첨부파일 서버PC에 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		String himg = multi.getFilesystemName("himg");	System.out.println("himg : " + himg);
		String hname = multi.getParameter("hname");	System.out.println("hname : " + hname);
		String hphone = multi.getParameter("hphone");	System.out.println("hphone : " + hphone);
		String hposition = multi.getParameter("hposition");	System.out.println("hphone : " + hposition);
		
		HrmDto hrmDto = new HrmDto(himg, hname, hphone, hposition);
		boolean result = HrmDao.getInstance().inputHrm(hrmDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}





















