package com.iu.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO;
	
	public PointService() {
		pointDAO = new PointDAO();
	}
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
	}
	
	//2. SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		return pointDAO.pointSelect(num);
	}
	
	//Delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	
	
	
	
}
