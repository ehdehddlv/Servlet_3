package com.iu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.member.MemberDTO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//ServletRequest는 httpsession의 조상
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		String command = ((HttpServletRequest)request).getPathInfo();
		
		if(memberDTO != null) {
			String id = memberDTO.getId();
			if(id.equals("admin")) {
				// admin
				System.out.println("Admin");
				chain.doFilter(request, response);
			}else {
				// member
				System.out.println("Member");
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
				
				//나중에 해결
//				request.setAttribute("result", "권한이 필요합니다.");
//				request.setAttribute("path", "../");
//				RequestDispatcher view = request.getRequestDispatcher("../common/result.jsp");
//				view.forward(request, response);
			}
		}else {
			// 로그인 안된 상태
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
