package jspweb.test.controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileDownLoad() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 다운로드할 파일 경로 찾기
			// 1. 다운로드 할 파일명 요청
		String filename = request.getParameter("filename");
			// 2. 첨부파일 파일 경로
		String uploadpath = request.getServletContext().getRealPath("/board/file");
			// 3. 다운로드 할 파일의 전체 경로
		String filepath = uploadpath + "/" + filename;
		
		System.out.println(filepath);
		
		// 2. 응답 : 파일 다운로드시 옵션
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") );
						// URLEncoder.encode(텍스트, "인코딩타입"); --> UR(HTTP주소)의 한글 깨짐 방지
		
		// 3. 파일 내보내기
			// 1. 파일 객체화 [해당 경로의 파일을 객체화 했을때 다양한 메소드 제공]
		File file = new File(filepath);
			// 2. 파일 입력 스트림 객체[ 파일을 바이트로 읽어옴 ]
		FileInputStream fin = new FileInputStream(file);
			// 3. 읽어온 바이트를 저장할 배열 선언( 배열의 길이 = 파일의 용량 )
		byte[] bytes = new byte[(int)file.length()];
			// 4. 바이트를 읽어서 배열에 저장하기
		fin.read(bytes);
			// 5. 파일 출력 스트립 객체[ 출력할 위치가 reponse ]
		BufferedOutputStream oin = new BufferedOutputStream(response.getOutputStream());
		// ServletOutputStream oin = response.getOutputStream();
			// 6. 파일 내보내기
		oin.write(bytes);
		
		// 4. 대용량 전송시 안전하게 스트림(바이트이동통로) 닫기
		fin.close(); oin.flush(); oin.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}





















