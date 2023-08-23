package 과제;

public class accountbookDto {
	private int cno;
    private String citem;
    private String cpayment;
    private String cdate;
    
    public accountbookDto() {}

	public accountbookDto(int cno, String citem, String cpayment, String cdate) {
		super();
		this.cno = cno;
		this.citem = citem;
		this.cpayment = cpayment;
		this.cdate = cdate;
	}

	public accountbookDto(String citem, String cpayment, String cdate) {
		super();
		this.citem = citem;
		this.cpayment = cpayment;
		this.cdate = cdate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCitem() {
		return citem;
	}

	public void setCitem(String citem) {
		this.citem = citem;
	}

	public String getCpayment() {
		return cpayment;
	}

	public void setCpayment(String cpayment) {
		this.cpayment = cpayment;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "accountbookDto [cno=" + cno + ", citem=" + citem + ", cpayment=" + cpayment + ", cdate=" + cdate + "]";
	}
    
    
}
