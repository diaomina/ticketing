package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.domain.Member;
import com.cn.domain.Pmember;
import com.cn.service.PmemberService;
import com.cn.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: GetPmemberByMemberIdServlet 
 * @Description: 根据MemberId获取会员个人信息，展示到myPmember.jsp界面
 * @author: ljy
 * @date: 2019年9月21日 上午2:44:30
 */
public class GetPmemberByMemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPmemberByMemberIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp = request.getParameter("temp");
		
		PmemberService pmemberService = new PmemberServiceImpl();
		
		// 判断是否为管理员
		if(temp!=null && !"".equals(temp) && "admin".equals(temp)) {
			// 管理员查询会员个人信息
			Integer memberId = Integer.valueOf(request.getParameter("memberId"));
			Pmember pmember = pmemberService.getPmemberByMemberId(memberId);
			request.setAttribute("pmember", pmember);
			request.getRequestDispatcher("pages/admin/right/updatePmember.jsp").forward(request, response);
			
		} else {
			// 会员查询个人信息
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			if(member != null) {
				Pmember pmember = pmemberService.getPmemberByMemberId(member.getMemberId());
				request.setAttribute("pmember", pmember);
				request.getRequestDispatcher("pages/user/myCenter/right/myPmember.jsp").forward(request, response);
			} else {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
