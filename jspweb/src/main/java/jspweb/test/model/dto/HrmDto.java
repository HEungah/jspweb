package jspweb.test.model.dto;

public class HrmDto {
	
	private int hno;
    private String himg;
    private String hname;
    private String hphone;
    private String hposition;
    private String hdate;
    
    public HrmDto() {}

	public HrmDto(int hno, String himg, String hname, String hphone, String hposition, String hdate) {
		super();
		this.hno = hno;
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
		this.hdate = hdate;
	}

	public HrmDto(String himg, String hname, String hphone, String hposition) {
		super();
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHposition() {
		return hposition;
	}

	public void setHposition(String hposition) {
		this.hposition = hposition;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", himg=" + himg + ", hname=" + hname + ", hphone=" + hphone + ", hposition="
				+ hposition + ", hdate=" + hdate + "]";
	}
    
    

}
