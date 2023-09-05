package jspweb.test.model.dao;

import java.util.ArrayList;

import jspweb.test.model.dto.BoardDto;

public class BoardDao extends Dao{
	
	private static BoardDao boardDao = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	
	// 1. 글쓰기
	public boolean writeBoard(BoardDto bDto) {
		
		try {
			String sql ="insert into board(btitle, bcontent, bfile, mno, bcno) values(?, ? , ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bDto.getBtitle());
			ps.setString(2, bDto.getBcontent());
			ps.setString(3, bDto.getBfile());
			ps.setInt(4, bDto.getMno());
			ps.setInt(5, bDto.getBcno());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 모든 글 출력
	public ArrayList<BoardDto> printBoard(int bcno,int listSize, int startrow){
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
		String sql = "";
		
		try {
			if(bcno != 0) {
				sql = "select b.*, m.mid, bc.bcname, m.mimg from board b, member m, bcategory bc where b.bcno = bc.bcno and b.mno = m.mno and b.bcno = ? order by b.bno desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bcno);
				ps.setInt(2, startrow);
				ps.setInt(3, listSize);
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
					list.add(bDto);
				}
				
			}else {
				sql = "select b.*, m.mid, bc.bcname, m.mimg from board b, member m, bcategory bc where b.bcno = bc.bcno and b.mno = m.mno order by b.bno desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, startrow);
				ps.setInt(2, listSize);
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
					list.add(bDto);
				}
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public int getTotalSize(int bcno) {
		
		try {
			String sql = "select count(*)from board b";
			// 만악에 전체보기가 아니면[카테고리별 개수]
			if(bcno != 0) {
				sql += " where b.bcno = " + bcno;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return 0;
	}
	
	// 3. 개별 글 출력
	public BoardDto printPBoard(int bno) {
		
		
		try {
			String sql = "select b.*, m.mid, bc.bcname, m.mimg from board b, member m, bcategory bc where b.bcno = bc.bcno and b.mno = m.mno and b.bno = ? order by b.bno desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), 
						rs.getString(9), rs.getString(10), rs.getString(11));
				return bDto;
			}
			
			
		} catch (Exception e) {}
		
		return null;
	}
	
	// 카테고리별 게시물 출력
	public ArrayList<BoardDto> printCBoard(int bcno, int listSize){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "";
		
		try {
			if(bcno != 0) {
				sql = "select b.*, m.mid, bc.bcname, m.mimg from board b, member m, bcategory bc where b.bcno = bc.bcno and b.mno = m.mno and b.bcno = ? order by b.bno desc limit ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bcno);
				ps.setInt(2, listSize);
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
					list.add(bDto);
				}
			}else {
				sql = "select b.*, m.mid, bc.bcname, m.mimg from board b, member m, bcategory bc where b.bcno = bc.bcno and b.mno = m.mno order by b.bno desc limit ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, listSize);
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
					list.add(bDto);
				}
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		
		return null;
	}
	
	// 4. 게시물 수정
	
	public boolean updateVeiw(BoardDto bDto) {
		
		System.out.println(bDto);
		
		try {
			String sql = "update board set btitle = ?, bcontent = ?, bfile = ?, bdate = now(), bview = 0, bcno = ? where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bDto.getBtitle());
			ps.setString(2, bDto.getBcontent());
			ps.setString(3, bDto.getBfile());
			ps.setInt(4, bDto.getBcno());
			ps.setInt(5, bDto.getBno());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 5. 게시물 삭제
	public boolean deleteVeiw(int bno) {
		
		try {
			String sql = "delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 6. 조회수 증가
	public boolean viewPlus(int bno) {
		try {
			String sql = "update board set bview = bview + 1 where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}

}
