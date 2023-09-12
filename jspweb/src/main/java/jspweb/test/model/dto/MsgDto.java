package jspweb.test.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import jspweb.test.model.dao.MemberDao;

public class MsgDto {	// 주고받을 메시지 정보들을 설계한 클래스
	
	private String frommid;	// 보낸 사람
	private String msg;	// 보낸 내용
	private String frommimg;		//보낸사람 프로필사진
	private String date;		// 보낸시간
	
	public MsgDto() {}
	
	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		// 객체 생성시 추가코드
			// 1. 보낸사람의 프로필 가져오기
			this.frommimg = MemberDao.getInstance().info(frommid).getMimg();
			// 2. 보낸일시 구하기
				// 2-1 Date클래스	(new Date() : 현재시간과 날짜를 제공하는 클래스)
				Date date = new Date();
				// 2-2 날짜 포멧(형식) : SimpleDateFormat
				SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm");
					// y연도 M월 d일 h시m분s초 aa오전오후
				this.date = sdf.format(date);	// 현재시간을 정의한형식으로 변환시킴
	}

	public MsgDto(String frommid, String msg, String frommimg, String date) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		this.frommimg = frommimg;
		this.date = date;
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + ", frommimg=" + frommimg + ", date=" + date + "]";
	}
	
	
	
}
