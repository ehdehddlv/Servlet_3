package com.iu.member;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}

	//1. Join
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberJoin(memberDTO);
	}
	
	//2. Login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	//3. My Page
	public MemberDTO memberPage(String id) throws Exception{
		return memberDAO.memberPage(id);
	}
	
	//4. MemberDelete(파라미터)
//	public int memberDelete(String id) throws Exception{
//		return memberDAO.memberDelete(id);
//	}
	
	//4.1 MemberDelete(세션)
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	
	//5. MemberUpdate
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	
}//end class
