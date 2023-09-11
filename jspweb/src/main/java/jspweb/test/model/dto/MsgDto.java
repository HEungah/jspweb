package jspweb.test.model.dto;

public class MsgDto {
	
	private String frommid;	// 보낸 사람
	private String msg;	// 보낸 내용
	
	public MsgDto() {}

	public MsgDto(String mid, String msg) {
		super();
		this.frommid = mid;
		this.msg = msg;
	}

	public String getFromMid() {
		return frommid;
	}

	public void setFromMid(String mid) {
		this.frommid = mid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDto [mid=" + frommid + ", msg=" + msg + "]";
	}
	
	
}
