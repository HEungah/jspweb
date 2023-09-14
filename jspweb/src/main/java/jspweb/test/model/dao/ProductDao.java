package jspweb.test.model.dao;

import java.sql.Statement;

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
	
	// 2. 제품 전체 출력
	
	// 3. 제품 개별 조회
	
	// 4. 제품 수정
	
	// 5. 제품 삭제
	
}
