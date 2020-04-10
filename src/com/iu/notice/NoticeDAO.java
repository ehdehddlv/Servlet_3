package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnect;

public class NoticeDAO {

	//1. List
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from notice order by no desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setWritedate(rs.getDate("writedate"));
			noticeDTO.setViews(rs.getInt("views"));
			ar.add(noticeDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	//2. Add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		int result = 0;
		
		Connection con = DBConnect.getConnect();
		
		String sql = "insert into notice values(?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, noticeDTO.getNo());
		st.setString(2, noticeDTO.getTitle());
		st.setString(3, noticeDTO.getId());
		st.setDate(4, noticeDTO.getWritedate());
		st.setInt(5, noticeDTO.getViews());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//3. Mod(Update)
	public int noticeMod(NoticeDTO noticeDTO) throws Exception{
		int result = 0;
		
		Connection con = DBConnect.getConnect();
		
		String sql = "update notice set title=? where no=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getTitle());
		st.setInt(2, noticeDTO.getNo());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	
}//end class
