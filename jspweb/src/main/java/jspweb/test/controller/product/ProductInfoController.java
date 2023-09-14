package jspweb.test.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jspweb.test.model.dao.ProductDao;
import jspweb.test.model.dto.MemberDto;
import jspweb.test.model.dto.ProductDto;

@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInfoController() {
        super(); 
    }
    
    // 1. 제품등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		// *commons.jar 이용한 업로드 구현
    	// commons-io.jar, commons-fileupload.jar 빌드 필요함
    	
    	// 1. 요청방식 2. 저장위치 3. 용량 4. 한글인코딩 5. 파일명중복방지
    	
    	// 1. 저장경로 [첨부파일이 저장될 폴더 위치]
    	String uploadPath = request.getServletContext().getRealPath("/product/img");
    	
    	// 2. 업로드 할 파일아이템저장소 객체 [commos.jar 라이브러리 사용]
    	DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    	itemFactory.setRepository(new File(uploadPath));	// 저장위치
    	itemFactory.setSizeThreshold(1024*1024*1024);	// 용량
    	itemFactory.setDefaultCharset("UTF-8");	// 한글인코딩
    	
    	// 3. 파일 업로드 객체 [commos import]
    	ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
    	
    	// 4. 파일 업로드 요청 [요청방식 : request]
    	try {
    		
    		Map<Integer, String> imgList = new HashMap<>();
    		
    				// form 전송시 모든 데이터 한번에 요청해서 가져옴
			List<FileItem> fileList = fileUpload.parseRequest(request);
			
			// 5. 업로드 실행
			int i = 0;
			for(FileItem item : fileList) {		// 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기
				
				// 1. 일반 필드 [item.isFormField() : 만약 일반 폼필드이면 true/ file 필드이면 false]
				if(item.isFormField()) {
					System.out.println(item.getString());	// .getString() : 해당 요청 input의 value 호출
					
				}
				// 2. file 필드
				else {
					// 만약에 파일 필드이면 업로드 진행
					// 6. 업로드 경로 + 파일명 [조합]
						// 파일명에 중복이 있을때 식별 생성
						UUID uuid = UUID.randomUUID();
							// UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약
						String filename = uuid+ "-" + item.getName().replaceAll("-", "_");
													// 만약에 파일명에 "-"이 존재하면 "_"로 변경
													// 파일명과 UUID를 식별하기 위해서
					// UUID-파일명	
					File fileUploadPath = new File(uploadPath + "/" + filename);
					
						System.out.println("업로드경로와 파일명이 조합된 경로 : " + fileUploadPath);
					item.write( fileUploadPath );		// 파일을 업로드할 경로를 file 타입으로 제공
					
					// 7. 업로드 된 파일명을 Map에 저장[db저장용]
					i++;
					imgList.put(i, item.getName());
				}
			}
			// 회원번호	(서블릿 세션 활용)
			Object object = request.getSession().getAttribute("loginDto");
			MemberDto memberDto = (MemberDto)object;
			int mno = memberDto.getMno();
			
			ProductDto productDto = new ProductDto(
					Integer.parseInt(fileList.get(0).getString()),
					fileList.get(1).getString(),
					fileList.get(2).getString(),
					Integer.parseInt(fileList.get(3).getString()),
					fileList.get(4).getString(),
					fileList.get(5).getString(), 
					mno,
					imgList
					);
			System.out.println(productDto);
			
			boolean result = ProductDao.getInstance().register(productDto);
			System.out.println(result);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
			
		} catch (Exception e) {System.out.println(e);}
    	
    }
    
    // 2. 제품출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	// 3. 제품수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}


/* cos.jar를 썻을때
 * 
 * MultipartRequest multi = new MultipartRequest( request,
 * request.getServletContext().getRealPath("/product/img"), 1024*1024*1024,
 * "UTF-8", new DefaultFileRenamePolicy());
 * 
 * String pcno = multi.getParameter("pcno"); String pname =
 * multi.getParameter("pname"); String pcontent =
 * multi.getParameter("pcontent"); String pprice = multi.getParameter("pprice");
 * //String pimg = multi.getFilesystemName("pimg"); Enumeration pimg =
 * multi.getFileNames(); // getFilesystemName() : 첨부된 하나의 파일명 호출
 * System.out.println(pimg);
 */
