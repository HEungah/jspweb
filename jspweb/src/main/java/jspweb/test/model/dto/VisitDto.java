package jspweb.test.model.dto;

public class VisitDto {
	// 1. 필드
	private int vno;
    private String vwriter;
    private String vpw;
    private String vcontent;
    private String vdate;
    // 생성자[기본,풀]
    public VisitDto() {}
    
    // 저장시 사용 생성자
	public VisitDto(String vwriter, String vpw, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpw = vpw;
		this.vcontent = vcontent;
	}



	public VisitDto(int vno, String vwriter, String vpw, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpw = vpw;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}

	// 메소드(get, set, toString)
	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getVpw() {
		return vpw;
	}

	public void setVpw(String vpw) {
		this.vpw = vpw;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	@Override
	public String toString() {
		return "VisitDto [vno=" + vno + ", vwriter=" + vwriter + ", vpw=" + vpw + ", vcontent=" + vcontent + ", vdate="
				+ vdate + "]";
	}
	
	
    
    
	
}
