package com.iu.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnect;

public class PointDAO {

	//DAO (Data Access Object)
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		
		//1. DB 연결
		Connection con = DBConnect.getConnect();
		//2. SQL문 작성
		String sql = "select * from point order by num asc";
		//3. SQL 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값 세팅
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			PointDTO pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			ar.add(pointDTO);
		}
	
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}//end list
	
	
	//2. SelectOne
	public PointDTO pointSelect(int num) throws Exception {
		PointDTO pointDTO = null;
		
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from point where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return pointDTO;
	
	}//end selectone
	
	
	
	//3. Insert
	
	//4. Update
	
	//5. Delete
	public int pointDelete(int num) throws Exception{
		int result=0;
		Connection con = DBConnect.getConnect();
		
		String sql = "Delete point where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result; 
		
	}//end delete
}
