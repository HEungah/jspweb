package jspweb.test.controller.product;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInfoController() {
        super(); 
    }
    
    // 1. 제품등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	MultipartRequest multi = new MultipartRequest(
    			request, 
    			request.getServletContext().getRealPath("/product/img"),
    			1024*1024*1024,
    			"UTF-8",
    			new DefaultFileRenamePolicy());
    	
    	String pcno = multi.getParameter("pcno");
    	String pname = multi.getParameter("pname");
    	String pcontent = multi.getParameter("pcontent");
    	String pprice = multi.getParameter("pprice");
    	//String pimg = multi.getFilesystemName("pimg");
    	Enumeration pimg = multi.getFileNames();
    		// getFilesystemName() : 첨부된 하나의 파일명 호출
    		System.out.println(pimg);
    	
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
