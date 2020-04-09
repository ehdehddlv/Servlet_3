package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {

	//1. Join
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result = 0;
		Connection con = DBConnect.getConnect();
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//2. Login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnect();
			
		String sql = "select * from member where id=? and password=?";
		
		PreparedStatement st = con.prepareStatement(sql);
			
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
			
		ResultSet rs = st.executeQuery();
			
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		}else {
			memberDTO = null;
		}
			
		rs.close();
		st.close();
		con.close();
			
		return memberDTO;
	}
	
	//3. My Page
	public MemberDTO memberPage(String id) throws Exception{
		MemberDTO memberDTO = null;
		Connection con = DBConnect.getConnect();
		
		String sql = "select name, age, phone, email from member where id = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));	
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
		
	}
		
		
		
}//end class
