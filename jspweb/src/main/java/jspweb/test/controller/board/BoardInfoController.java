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
import jspweb.test.model.dto.PageDto;
import jspweb.test.service.FileService;


@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();
    }

    // 게시물출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		// 전체 게시물 출력
		if(type.equals("1")) {
			
			// -------------------- 검색 처리 ---------------------
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			System.out.println(key);
			System.out.println(keyword);
			// --------------------------------------------------
			
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			// 페이징처리
			int listSize = Integer.parseInt(request.getParameter("listSize"));
			int page = Integer.parseInt(request.getParameter("page"));
			
			// 마지막페이지번호(마지막페이지번호 = 전체게시물수 /페이지별 최대게시물수)
				// 전체게시물수
			int totalsize = BoardDao.getInstance().getTotalSize(bcno, key, keyword);
				// 총페이지수
			int totalpage = totalsize%listSize == 0 ? totalsize/listSize : (totalsize/listSize) + 1;
			
			// 5. 페이지 번호버튼 시작번호, 마지막 번호
				// 5개씩 : 1~5페이지(1, 5) 6~10페이지(6, 10)
				// 10개씩 : 1~10페이지(1, 10) 11~20페이지(11, 20)
				// 15개씩 : 1~15페이지(1, 15) 16~30페이지(16, 30)
				/*
				 	페이지			시작 		마지막
				 	1페이지		1			5
				 	2				1			5
				 	3				1			5
				 	4				1			5
				 	5				1			5
				 	6				6			10
				 	7				6			10
				 	8				6			10
				 	9				6			10
				 	10				6			10
				 	11				11			15
				 	
				 	(page/btnsize)*btnsize + 1
				 */
			
				// 1. 페이지번호의 최대개수
			int btnsize = 5;
				// 2. 페이지버튼 번호의 시작번호
			int startbtn = ((page-1)/btnsize)*btnsize + 1; System.out.println(startbtn);
				// 3. 페이지버튼 번호의 마지막 번호
			int endbtn = (startbtn + btnsize) - 1;
				// 단 마지막 번호는 총페이지 수보다 커질수 없다.
				if(endbtn >= totalpage) {
					endbtn = totalpage;
				}
			
			// 페이지별 레코드의 시작번호
			int startrow = (page-1)*listSize;	// 페이지번호*최대게시물수
			
			
			ArrayList<BoardDto> result = BoardDao.getInstance().printBoard(bcno, listSize, startrow, key, keyword);
			System.out.println(result);
			PageDto pageDto = new PageDto(page, listSize, startrow, totalsize, totalpage, startbtn, endbtn,result);
			
			// 리턴값을 JSON 형식으로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString(pageDto);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonArray);
		
		}
		// 개별 게시물 출력
		else if(type.equals("2")) {
			
			
			int bno = Integer.parseInt(request.getParameter("bno"));
			// 조회수 증가
			boolean result = BoardDao.getInstance().viewPlus(bno);
			
			// 만약에 요청한 사람과 게시물 작성한 사람이 동일하면
				// 로그인 정보[세션]
			
			BoardDto bDto = BoardDao.getInstance().printPBoard(bno);
			
			Object object =  request.getSession().getAttribute("loginDto");
			if(object == null) {	// 비로그인
				bDto.setIshost(false);
			}else {	// 로그인
				MemberDto login = (MemberDto)object;
				
				if(login.getMno() == bDto.getMno()) {	// 작성한사람의 게시물일경우
					bDto.setIshost(true);
				}else {		// 작성한사람의 게시물이 아닐경우
					bDto.setIshost(false);
				}
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString(bDto);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonArray);
			
		}
	}

	// 게시물 등록
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
    	
    	int bcno = Integer.parseInt(multi.getParameter("bcno"));
    	String btitle = multi.getParameter("btitle");
    	String bcontent = multi.getParameter("bcontent");
    	String bfile = multi.getFilesystemName("bfile");
    	
    	BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); 
    	boolean result = BoardDao.getInstance().writeBoard(boardDto);
    	
    	response.setContentType("application/json; charset=utf-8");
    	response.getWriter().print(result);
	}

	// 게시물 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/file");
		
    	MultipartRequest multi = new MultipartRequest(
				request,	// 요청방식
				uploadpath,	// 2. 첨부파일을 저장할 폴더 경로(절대경로)
				1024*1024*1024,		// 3. 첨부파일 용량 허용 범위[ 바이트단위]	1GB
				"UTF-8",				// 4. 한글인코딩타입
				new DefaultFileRenamePolicy()	// 5. 만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기
		);
    	
    	Object session = request.getSession().getAttribute("loginDto");
    	int mno = ((MemberDto)session).getMno();
    	
    	int bcno = Integer.parseInt(multi.getParameter("newbcno"));
    	int bno = Integer.parseInt(multi.getParameter("bno")); System.out.println(bno);
    	String btitle = multi.getParameter("newbtitle"); System.out.println(btitle);
    	String bcontent = multi.getParameter("newbcontent"); System.out.println(bcontent);
    	String bfile = multi.getFilesystemName("newbfile");
    	
    	BoardDto boardDto = new BoardDto(bno, btitle, bcontent, bfile, mno, bcno);
    	System.out.println("Dto" + boardDto);
    	
    	// 수정한 파일이 없으면
    	if(boardDto.getBfile() == null) {
    		
    	}
    	
		boolean result = BoardDao.getInstance().updateVeiw(boardDto);
		
		response.setContentType("application/json; charset=utf-8");
    	response.getWriter().print(result);
	}

	
	// 게시물 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
			// 레코드 삭제 전에 파일이름 꺼내두기(삭제후 파일이름 호출이 불가능하기 때문)
		String filename = BoardDao.getInstance().printPBoard(bno).getBfile();
		
		boolean result = BoardDao.getInstance().deleteVeiw(bno);
		
			// 만약에 게시물 삭제가 성공되면 .. 서버에 업로드된 파일도 같이 삭제
		if(result) {	// 만약에 게시물 삭제 성공이면
			filename = request.getServletContext().getRealPath("/board/file") + "/" + filename;
			FileService.fileDelete(filename);
		}
		
		response.setContentType("application/json; charset=utf-8");
    	response.getWriter().print(result);
		
	}
	
	// 파일 삭제 함수
	

}














