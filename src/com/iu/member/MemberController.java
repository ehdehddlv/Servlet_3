package com.iu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        memberService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//join, login etc..
		String command = request.getPathInfo();
		//get, post
		String method = request.getMethod();
		//forward, redirect
		boolean check = true;
		//URL주소 담을 변수
		String path = "";
		
		try {
		
		if(command.equals("/memberJoin")) {
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPassword(request.getParameter("password"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				
				
				int result = memberService.memberJoin(memberDTO);
				check = false;
				path = "../";
			
				
			}else {
				path = "../WEB-INF/views/member/memberJoin.jsp";
			}
		
		}else if(command.equals("/memberLogin")){
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPassword(request.getParameter("password"));
				
				memberDTO = memberService.memberLogin(memberDTO);
				
				if(memberDTO != null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					check = false;
					path = "../";
				}else {
					request.setAttribute("result", "Login Fail");
					request.setAttribute("path", "./memberLogin");
					path = "../WEB-INF/views/common/result.jsp";
				}
				
			}else {
				path = "../WEB-INF/views/member/memberLogin.jsp";
			}
			
		}else if(command.equals("/memberLogout")) {
			HttpSession session = request.getSession();	//세션은 브라우저마다 1개씩 생성됌
			//session.removeAttribute("member");	//세션을 없앰 (잘안씀)
			session.invalidate();	//세션을 없앰
			check = false;
			path = "../";
		}else if(command.equals("/memberPage")) {
			//HttpSession session = request.getSession();
			
			
			path = "../WEB-INF/views/member/memberPage.jsp";
			
		}else if(command.equals("/memberDelete")) {
		
			//파라미터로 id 꺼내서 지우는 방법
			//String id = request.getParameter("id");
			//int result = memberService.memberDelete(id);
			
			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			int result = memberService.memberDelete(memberDTO);
			
			if(result > 0) {
				session.invalidate();
			}
			
			check = false;
			path = "../";
			
		}else if(command.equals("/memberUpdate")){
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setId(request.getParameter("id"));
				
				int result = memberService.memberUpdate(memberDTO);
				
				HttpSession session = request.getSession();
				
				String msg = "회원정보 수정 실패";
				if(result > 0) {
					msg = "회원정보 수정 성공";
					request.setAttribute("path", "../");
					session.setAttribute("member", memberDTO);
				}else {
					request.setAttribute("path", "./memberPage");
				}
				
				request.setAttribute("result", msg);
				
				path = "../WEB-INF/views/common/result.jsp";
				
			}else {
				//String id = request.getParameter("id");
				//MemberDTO memberDTO = memberService.memberPage(id);
				path = "../WEB-INF/views/member/memberUpdate.jsp";
			}
	
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
