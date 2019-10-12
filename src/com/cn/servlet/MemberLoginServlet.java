package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.domain.Admin;
import com.cn.domain.Member;
import com.cn.service.AdminService;
import com.cn.service.MemberService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.service.impl.MemberServiceImpl;
import com.cn.util.DateUtil;

/**
 * 
 * @ClassName: MemberLoginServlet 
 * @Description: 会员登录的Servlet
 * @author: ljy
 * @date: 2019年9月19日 下午10:58:30
 */
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
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
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.getAdminByName(userName);
		
		// 创建Session，存储登录的用户对象
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30 * 60);
		
		PrintWriter out = response.getWriter();
		
		// 判断是否是管理员账号
		if(admin !=null) {
			if(admin.getPassword().equals(passWord)) {
				
				// 更新登录状态和登录时间
				admin.setIsUse(1);
				admin.setLoginTime(DateUtil.now());
				adminService.updateAdmin(admin);

				
				// 将登录对象存入session
				session.setAttribute("admin", admin);
				
				// 跳转到管理界面
				out.write("<script>alert('登录成功！欢迎你,"+admin.getUserName()+"');"
					    + "window.location.href='pages/admin/adminMain.jsp'</script>");
				
				//response.sendRedirect("pages/admin/adminMain.jsp");
			} else {
				
				out.write("<script>alert('密码错误，请重新输入！');"
					    + "window.location.href='pages/user/memberLogin.jsp'</script>");
				//request.setAttribute("msg","密码错误，请重新输入！");
				//request.getRequestDispatcher("pages/user/memberLogin.jsp").forward(request, response);
			}
			
		} else {
			// 判断是否是会员账号
			MemberService memberService = new MemberServiceImpl();
			Member member = memberService.getMemberByName(userName);
			if(member != null) {
				// 密码正确，转到首页
				if(passWord.equals(member.getPassword())) {
					
					// 先修改数据库登录状态和登录时间
					member.setIfUse(1);
					member.setLogintimes(DateUtil.now());
					memberService.updateMember(member);
					
					// 将登录信息存入session
					/*HttpSession session = request.getSession();
					session.setMaxInactiveInterval(30 * 60);*/
					session.setAttribute("member", member);
					
					// 跳转到首页
					out.write("<script>alert('登录成功！欢迎你,"+member.getUserName()+"');"
						    + "window.location.href='pages/user/home.jsp'</script>");
					
					//String welcome ="欢迎您，" + member.getUserName();
					//request.setAttribute("welcome", welcome);
					//request.getRequestDispatcher("pages/user/home.jsp").forward(request, response);
					
				} else {
					out.write("<script>alert('密码错误，请重新输入！');"
						    + "window.location.href='pages/user/memberLogin.jsp'</script>");
					//request.setAttribute("msg","密码错误，请重新输入！");
					//request.getRequestDispatcher("pages/user/memberLogin.jsp").forward(request, response);
				}
			} else {
				out.write("<script>alert('该用户不存在！');"
					    + "window.location.href='pages/user/memberLogin.jsp'</script>");
				//request.setAttribute("msg","该用户不存在！");
				//request.getRequestDispatcher("pages/user/memberLogin.jsp").forward(request, response);
			}
		}
		
		out.close();
		
	}

}
