package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Member;
import com.cn.service.MemberService;
import com.cn.service.impl.MemberServiceImpl;

/**
 * 
 * @ClassName: MemberCenterServlet 
 * @Description: 会员中心的Servlet，获取所有会员信息
 * @author: ljy
 * @date: 2019年9月20日 下午3:17:34
 */
public class MemberCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取所有会员的信息
		MemberService memberService = new MemberServiceImpl();
		List<Member> memberList =  memberService.getAllMember();
		
		if(memberList!=null && memberList.size()>0) {
			request.setAttribute("memberList", memberList);
		} else {
			request.setAttribute("msg", "暂时没有任何会员！");
		}
		
		request.getRequestDispatcher("pages/admin/right/memberCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
