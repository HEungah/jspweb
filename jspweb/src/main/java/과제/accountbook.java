package 과제;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jspweb.test.model.dao.VisitDao;


@WebServlet("/accountbook")
public class accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public accountbook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<accountbookDto> result = accountbookDao.getInstance().aread();
		
		System.out.println(result.get(1).getCitem());
		System.out.println(result.get(1).getCpayment());
		System.out.println(result.get(1).getCdate());
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aItem = request.getParameter("aItem");
		String aPayment = request.getParameter("aPayment");
		String aDate = request.getParameter("aDate");
		
		accountbookDto aDto = new accountbookDto(aItem, aPayment, aDate);
		System.out.println(aDto.getCitem());
		System.out.println(aDto.getCpayment());
		System.out.println(aDto.getCdate());
		
		boolean result = accountbookDao.getInstance().awrite(aDto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno")); System.out.println("cno : " + cno);
		String citem = request.getParameter("citem"); System.out.println("citem : " + citem);
		String cpayment = request.getParameter("cpayment"); System.out.println("cpayment : " + cpayment);
		String cdate = request.getParameter("cdate"); System.out.println("cdate : " + cdate);
		
		boolean result = accountbookDao.getInstance().aupdate(cno, citem,cpayment, cdate);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		boolean result = accountbookDao.getInstance().adelete(cno);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
