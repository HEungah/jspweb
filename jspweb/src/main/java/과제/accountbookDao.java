package 과제;

import java.util.ArrayList;

import jspweb.test.model.dao.Dao;

public class accountbookDao extends Dao{
	
	private static accountbookDao aDao = new accountbookDao();
	
	private accountbookDao() {}
	
	public static accountbookDao getInstance() {
		return aDao;
	}
	
	public boolean awrite(accountbookDto aDto) {
		try {
			String sql ="insert accountbook(citem, cpayment, cdate) values(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aDto.getCitem());
			ps.setString(2, aDto.getCpayment());
			ps.setString(3, aDto.getCdate());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	public ArrayList<accountbookDto> aread(){
		ArrayList<accountbookDto> list = new ArrayList<>();
		
		try {
			String sql = "select*from accountbook order by cno desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				accountbookDto aDto = new 
						accountbookDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
								rs.getString(4));
				list.add(aDto);
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public boolean aupdate(int cno, String citem, String cpayment, String cdate) {
		
		try {
			String sql = "update accountbook set citem = ?, cpayment = ?, cdate = ? where cno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(4, cno);
			ps.setString(1, citem);
			ps.setString(2, cpayment);
			ps.setString(3, cdate);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
		
	}
	
	public boolean adelete(int cno) {
		try {
			String sql = "delete from accountbook where cno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}

}



















