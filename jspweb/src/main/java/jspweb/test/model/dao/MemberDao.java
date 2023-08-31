package jspweb.test.model.dao;

import java.time.LocalDateTime;

import jspweb.test.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	
	private MemberDao() {};
	
	public static MemberDao getInstance() {
		return memberDao;
	}
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
		
		try {
			String sql = "insert into member(mid, mpwd, memail, mimg) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 로그인
	public boolean login(String mid, String mpwd) {
		try {
			String sql = "select*from member where mid = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if(rs.next()) return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기
	
	// 5. 내정보 호출
	public MemberDto info(String mid) {
		try {
			String sql = "select mno, mid, memail, mimg from member where mid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto memberDto = new MemberDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), LocalDateTime.now().toString());
				return memberDto;
			}
			
		} catch (Exception e) {System.out.println(e);}
			
		return null;
	}
	
	// 6. 아이디/이메일 중복검사(true : 중복, false : 중복없음)
	public boolean findIdOrEmail(String type, String data) {
		try {
			String sql = "select*from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	// 7. 회원수정
	public boolean updateMember(int mno, String mimg, String mpwd, String newmpwd) {
		
		try {
			String sql = "update member set mimg = ?, mpwd = ? where mno = ? and mpwd = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mimg);
			ps.setString(2, newmpwd);
			ps.setInt(3, mno);
			ps.setString(4, mpwd);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 8. 회원탈퇴
	public boolean deleteMember(int mno, String mpwd) {
		
		try {
			String sql = "delete from member where mno = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	
	
	

}
