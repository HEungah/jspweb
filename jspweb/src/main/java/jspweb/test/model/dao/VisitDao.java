package jspweb.test.model.dao;

import java.util.ArrayList;

import jspweb.test.model.dto.VisitDto;

public class VisitDao extends Dao{

	// 싱글톤
	private static VisitDao visitDao = new VisitDao();
	
	private VisitDao() {}
	
	public static VisitDao getInstance() {
		return visitDao;
	}
	
	// 1. 저장[인수 : 저장할 내용이 담긴 Dto, 리턴 : 성공/실패의 boolean값]
	public  boolean vwriter(VisitDto visitDto) {
		// 0. try/catch
		try {
			String sql = "insert visitlog(vwriter, vpw, vcontent) values(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getVwriter());
			ps.setString(2, visitDto.getVpw());
			ps.setString(3, visitDto.getVcontent());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 호출[인수 : x, 리턴 : 여러개(ArrayList)의 방문록Dto]
	public ArrayList<VisitDto> vread(){
		ArrayList<VisitDto> list = new ArrayList<>();
		
		try {
			String sql ="select*from visitlog order by vdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// rs.next() : select 검색결과중 다음레코드 이동 --> 존재하면 true, 존재하지 않으면 false
			while(rs.next()) {
				VisitDto vDto = new
						VisitDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
								rs.getString(4), rs.getString(5));
				list.add(vDto);
			}
			return list;
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 3. 수정[인수 : 수정할 번호(int), 수정할 방문록내용(String), 비밀번호 체크(String), 리턴 : 성공/실패 boolean값] 
	public boolean vupdate(int vno, String vcontent, String vpw) {
		try {
			String sql = "update visitlog set vcontent = ? where vno = ? and vpw = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(2, vno);
			ps.setString(1, vcontent);
			ps.setString(3, vpw);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 4. 삭제[인수 : 삭제할 번호(int), 비밀번호 체크(String), 리턴 : 성공/실패 boolean값]
	public boolean vdelete(int vno, String vpw) {
		try {
			String sql = "delete from visitlog where vno = ? and vpw = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vno);
			ps.setString(2, vpw);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
}












