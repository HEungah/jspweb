package jspweb.test.controller.board;

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

import jspweb.test.model.dao.BoardDao;
import jspweb.test.model.dao.HrmDao;
import jspweb.test.model.dto.BoardDto;
import jspweb.test.model.dto.HrmDto;
import jspweb.test.model.dto.MemberDto;


@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();
    }

    // 게시물출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoardDto> result = BoardDao.getInstance().printBoard();
		System.out.println(result);
		// 리턴값을 JSON 형식으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/file");
    	System.out.println("board / file 폴더 실제(서버) 경로 : " + uploadpath);
		
    	MultipartRequest multi = new MultipartRequest(
				request,	// 요청방식
				uploadpath,	// 2. 첨부파일을 저장할 폴더 경로(절대경로)
				1024*1024*1024,		// 3. 첨부파일 용량 허용 범위[ 바이트단위]	1GB
				"UTF-8",				// 4. 한글인코딩타입
				new DefaultFileRenamePolicy()	// 5. 만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기
		);
    	
    	Object session = request.getSession().getAttribute("loginDto");
    	int mno = ((MemberDto)session).getMno();
    	
    	int bcno = Integer.parseInt(multi.getParameter("bcno"));	System.out.println("bcno : " + bcno);
    	String btitle = multi.getParameter("btitle");	System.out.println("btitle : " + btitle);
    	String bcontent = multi.getParameter("bcontent");	System.out.println("bcontent : " + bcontent);
    	String bfile = multi.getFilesystemName("bfile"); System.out.println("bfile : " +bfile);
    	
    	BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); 
    	boolean result = BoardDao.getInstance().writeBoard(boardDto);
    	
    	response.setContentType("application/json; charset=utf-8");
    	response.getWriter().print(result);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
