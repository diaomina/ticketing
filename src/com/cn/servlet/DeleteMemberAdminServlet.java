package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Pmember;
import com.cn.service.MemberService;
import com.cn.service.PmemberService;
import com.cn.service.impl.MemberServiceImpl;
import com.cn.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: DeleteMemberAdminServlet 
 * @Description: 管理员 删除会员
 * @author: ljy
 * @date: 2019年9月28日 下午9:31:52
 */
public class DeleteMemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		
		PmemberService pmemberService = new PmemberServiceImpl();
		MemberService memberService = new MemberServiceImpl();
		// 先删除pmember表内的会员个人信息
		Pmember pmember = pmemberService.getPmemberByMemberId(memberId);
		int recordNumber = pmemberService.delete(pmember.getPmemberId());
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			// 后删除member表内的会员信息
			int recordNumber1 = memberService.deleteMember(memberId);
			
			if(recordNumber1 == 1) {
				out.write("<script>alert('删除会员成功！');"
				    + "window.location.href='MemberCenterServlet'</script>");
			}else {
				out.write("<script>alert('很抱歉,删除会员失败！');"
					    + "window.location.href='MemberCenterServlet'</script>");
			}
			
		}else {
			out.write("<script>alert('很抱歉,删除会员失败！');"
				    + "window.location.href='MemberCenterServlet'</script>");
		}
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
