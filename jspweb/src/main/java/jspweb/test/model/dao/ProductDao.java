package jspweb.test.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jspweb.test.model.dto.ProductDto;

public class ProductDao extends Dao{
	
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {
		return productDao;
	}
	
	// 1. 제품 등록
	public boolean register(ProductDto dto) {
		
		// 1-1 제품 등록
		try {
			String sql = "insert "
					+ "into product(pcno, pname, pcontent, pprice, plat, plng, mno) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			// sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dto.getPcno());
			ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcontent());
			ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat());
			ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			
			int count = ps.executeUpdate();
			rs = ps.getGeneratedKeys();	// 제품 등록시 생성된 식별키[pk]를 반환해서 rs에 저장
			rs.next();
			
			if(count == 1) {
				// 1-2 제품 등록후 이미지 등록
					// Map<Integer, String>	: map객체명.keySet() map 객체내 모든 키 호출 가능
				for(String value : dto.getImgList().values()) {
					sql = "insert into productimg(pimg, pno) values(?, ?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1, value);
					ps.setInt(2, rs.getInt(1));	
					ps.executeUpdate();
				}
				
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		// 1-2 제품 등록후 생성된 제품 pk를 가지고 이미지등록
		
		
		return false;
	}
	// 제품에 해당하는 이미지 출력하는 함수
	public Map<Integer, String> getProductImg(int pno){
		try {
			Map<Integer, String> imglist = new HashMap<>();	// 제품별 여러개 이미지
			String sql = "select*from productimg where pno = " + pno;
			PreparedStatement ps = conn.prepareStatement(sql);	// 다른함수에서 rs를 사용하기 때문에 새로 만듬
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				imglist.put(rs.getInt("pimgno"),rs.getString("pimg"));
			}
			return imglist;
			
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
	
	
	// 2. 제품 전체 출력
	public List<ProductDto> findByTop(int count){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			String sql = "select*from product order by pdate desc limit "+ count;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(findByPno(rs.getInt("pno")));
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 2. 카카오지도내 보고있는 동서남북 기준내 제품들을 출력
	public List<ProductDto> findByLatLng(String east, String west, String south, String north){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {	// 동쪽의 경도보다 크고 서쪽의 경도보다 작고, 남쪽 위도보도 크고 북쪽 위도보다 작다
			String sql = "select*from product where ? >=plng and ? <=plng and ? <=plat and ? >=plat order by pdate";
			ps = conn.prepareStatement(sql);
			ps.setString(1, east); ps.setString(2, west);
			ps.setString(3, south); ps.setString(4, north);
			rs = ps.executeQuery();
			System.out.println(sql);
			while(rs.next()) {
				list.add(findByPno(rs.getInt("pno")));
			}
			return list;
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 3. 제품 개별 조회
	public ProductDto findByPno(int pno) {
		
		try {
			String sql = "select*from product p natural join pcategory pc natural join member m where p.pno="+pno;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ProductDto productDto = new ProductDto(
						rs.getInt("pcno"), rs.getString("pcname"),
						rs.getInt("pno"), rs.getString("pname"),
						rs.getString("pcontent"), rs.getInt("pprice"),
						rs.getInt("pstate"), rs.getString("pdate"),
						rs.getString("plat"), rs.getString("plng"),
						rs.getInt("mno"),
						getProductImg(rs.getInt("pno")), rs.getString("mid")
						);
				return productDto;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 관리자용 제품 출력
	public List<ProductDto> findByAll(){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			String sql = "select*from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(findByPno(rs.getInt("pno")));
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	// 페이징 처리
	public int getTotalSize() {
		return 0;
	}
	
	
	// 제품 찜하기 등록(찜하기 상태가 아닐때=조건에 따른 레코드가 없을때)/취소(찜하기 상태가 아닐때/조건에 따른 레코드가 있을때)
	public boolean setWish(int mno, int pno) {
		
		String sql = "";
		
		try {		
			sql += getWish(mno, pno) ? 
				"delete from pwishlist where mno = ? and pno = ?" : 
				"insert into pwishlist values(?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
			
		} catch (Exception e) {System.out.println(e);}	
		return false;	
	}
	
	
	// 제품 찜하기 상태 출력
	public boolean getWish(int mno , int pno) {
		try {
			String sql = "select*from pwishlist where mno = ? and pno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 5. 현재 로그인된 회원의 찜한 제품[여러개] 정보를 출력함수
	public List<ProductDto> getWishProductList(int mno){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			// 현재 회원이 찜한 제품번호 찾기
			String sql = "select pno from pwishlist where mno = " + mno;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 현재 회원이 찜한 제품번호의 레코드반환
				// 찾은 제품번호 하나씩 findByPno() 함수에게 전달해서 제품정보를 list 담기
			while(rs.next()){
				list.add(findByPno(rs.getInt("pno")));
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
}














