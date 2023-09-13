package jspweb.test.model.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductDto {
	private int pcno;
	private String pcname;
	private int pno;
    private String pname;
    private String pcontent;
    private int pprice;
    private int pstate;
    private String pdate;
    private String plat;
    private String plng;
    private int mno;
    private int pimgno;
    
    Map<Integer, String> imgList = new HashMap<>();	// 제품별 이미지 여러개 저장
    
    private String mid;
    
    public ProductDto() {}

	public ProductDto(int pcno, String pcname, int pno, String pname, String pcontent, int pprice, int pstate,
			String pdate, String plat, String plng, int mno, int pimgno, Map<Integer, String> imgList, String mid) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.pimgno = pimgno;
		this.imgList = imgList;
		this.mid = mid;
	}
	
	// 제품 등록시 생성자
	
	public ProductDto(int pcno, String pname, String pcontent, int pprice, String plat, String plng, int mno,
			Map<Integer, String> imgList) {
		super();
		this.pcno = pcno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
	}

	public int getPcno() {
		return pcno;
	}

	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstate() {
		return pstate;
	}

	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getPimgno() {
		return pimgno;
	}

	public void setPimgno(int pimgno) {
		this.pimgno = pimgno;
	}

	public Map<Integer, String> getImgList() {
		return imgList;
	}

	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ProductDto [pcno=" + pcno + ", pcname=" + pcname + ", pno=" + pno + ", pname=" + pname + ", pcontent="
				+ pcontent + ", pprice=" + pprice + ", pstate=" + pstate + ", pdate=" + pdate + ", plat=" + plat
				+ ", plng=" + plng + ", mno=" + mno + ", pimgno=" + pimgno + ", imgList=" + imgList + ", mid=" + mid
				+ "]";
	}
    

}
