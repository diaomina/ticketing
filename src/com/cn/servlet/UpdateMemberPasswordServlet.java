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
 * @ClassName: UpdateMemberPasswordServlet 
 * @Description: 会员 修改密码
 * @author: ljy
 * @date: 2019年9月30日 下午11:01:33
 */
public class UpdateMemberPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		Member member = (Member) request.getSession().getAttribute("member");
		
		PrintWriter out = response.getWriter();
		
		// 判断原密码是否正确
		if(oldPassword!=null && member.getPassword().equals(oldPassword)) {
			// 修改密码
			member.setPassword(newPassword);
			MemberService memberService = new MemberServiceImpl();
			int recordNumber = memberService.updateMember(member);
			
			if(recordNumber == 1) {
				out.write("<script>alert('修改成功！');"
				    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉,修改失败！');"
					    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
			}
			
		} else {
			out.write("<script>alert('很抱歉,修改失败！');"
				    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
		}
		
		out.close();
		
		
		
	
	}

}
