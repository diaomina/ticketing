package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Member;
import com.cn.service.MemberService;
import com.cn.service.impl.MemberServiceImpl;

/**
 * 
 * @ClassName: UpdateMemberAdminServlet 
 * @Description: 管理员修改会员
 * @author: ljy
 * @date: 2019年9月28日 下午9:38:55
 */
public class UpdateMemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 从数据库获取这个会员的信息转发到修改界面
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		
		MemberService memberService = new MemberServiceImpl();
		Member member = memberService.getMemberById(memberId);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("pages/admin/right/updateMember.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 将修改后的数据更新到数据库
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		MemberService memberService = new MemberServiceImpl();
		Member member = memberService.getMemberById(memberId);
		member.setUserName(userName);
		member.setPassword(password);
		int recordNumber = memberService.updateMember(member);
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('修改会员成功！');"
			    + "window.location.href='MemberCenterServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,修改会员失败！');"
				    + "window.location.href='MemberCenterServlet'</script>");
		}
		
		out.close();
	}

}
