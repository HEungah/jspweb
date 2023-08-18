package jspweb.test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Text07")
public class Text07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Text07() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
			// Dao 처리 / 비지니스로직
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); 
		
		System.out.println("[JS] AJAX 가 보내온 데이터");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
			
		// 2. 응답
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
