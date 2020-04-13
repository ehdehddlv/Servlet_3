package com.iu.notice;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        noticeService = new NoticeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//한글
		response.setCharacterEncoding("UTF-8");	//한글
		
		//notice 관련
		String command = request.getPathInfo();
		
		//get, post
		String method = request.getMethod();
		
		//forward, redirect
		boolean check = true;
		
		//URL
		String path = "";
		
		try {
		
		if(command.equals("/noticeList")) {
			ArrayList<NoticeDTO> ar = noticeService.noticeList(); 
			request.setAttribute("nolist", ar);
			
			
			path = "../WEB-INF/views/notice/noticeList.jsp";
			
		}else if(command.equals("/noticeAdd")) {
			if(method.equals("POST")) {
				NoticeDTO noticeDTO = new NoticeDTO();
				
				noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
				noticeDTO.setTitle(request.getParameter("title"));
				noticeDTO.setId(request.getParameter("id"));
				noticeDTO.setWritedate(Date.valueOf(request.getParameter("writedate")));
				noticeDTO.setViews(Integer.parseInt(request.getParameter("views")));
				
				int result = noticeService.noticeAdd(noticeDTO);
				
				String msg = "공지 추가 실패";
				if(result > 0) {
					msg = "공지 추가 성공";
				}
				
				request.setAttribute("result", msg);
				request.setAttribute("path", "./noticeList");
			
				path = "../WEB-INF/views/common/result.jsp";
				
			}else {
				
				path = "../WEB-INF/views/notice/noticeAdd.jsp";
			}
			
		}else if(command.equals("/noticeSelect")) {
			
			path = "../WEB-INF/views/notice/noticeSelect.jsp";
		
		}else if(command.equals("/noticeMod")) {
			if(method.equals("POST")) {
				NoticeDTO noticeDTO = new NoticeDTO();
				
				noticeDTO.setTitle(request.getParameter("title"));
				noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
				
				int result = noticeService.noticeMod(noticeDTO);
				
				String msg = "공지 수정 실패";
				if(result > 0) {
					msg = "공지 수정 성공";
					request.setAttribute("path", "./noticeSelect?no="+noticeDTO.getNo());
				}else {
					request.setAttribute("path", "./noticeList");
				}
				
				request.setAttribute("result", msg);
				
				path = "../WEB-INF/views/common/result.jsp";
				
			}else {
				int no = Integer.parseInt(request.getParameter("no"));
				
				
			}
			
			path = "../WEB-INF/views/notice/noticeMod.jsp";
		}
		
			
		
		
		else {
			System.out.println("ETC");
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		//
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}


		
	}//end doget

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
