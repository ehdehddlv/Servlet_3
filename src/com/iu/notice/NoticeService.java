package com.iu.notice;

import java.util.ArrayList;

public class NoticeService {

	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	//1. List
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		return noticeDAO.noticeList();
	}
	
	//2. Add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeAdd(noticeDTO);
	}
	
	//3. Mod
	public int noticeMod(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeMod(noticeDTO);
	}
	
	//4.
	
	
	
}//end class
