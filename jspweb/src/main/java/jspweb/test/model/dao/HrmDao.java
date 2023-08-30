package jspweb.test.model.dao;

import java.util.ArrayList;

import jspweb.test.model.dto.HrmDto;

public class HrmDao extends Dao{
	
	private static HrmDao hrmDao = new HrmDao();
	
	private HrmDao() {}
	
	public static HrmDao getInstance() {
		return hrmDao;
	}
	
	public boolean inputHrm(HrmDto hrmDto) {
		
		try {
			String sql = "insert into hrm(himg, hname, hphone, hposition) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, hrmDto.getHimg());
			ps.setString(2, hrmDto.getHname());
			ps.setString(3, hrmDto.getHphone());
			ps.setString(4, hrmDto.getHposition());
			int row = ps.executeUpdate();
			if(row == 1) {
				return true;
			}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	public ArrayList<HrmDto> hread(){
		
		ArrayList<HrmDto> list = new ArrayList<>();
		
		try {
			String sql ="select*from hrm order by hdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String date = rs.getString(6).substring(0, 16);
				System.out.println(rs.getString(2));
				HrmDto hDto = new HrmDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), date);
				list.add(hDto);
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}

}
