package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Admin;
import com.cn.service.AdminService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.util.DateUtil;

/**
 * Servlet implementation class AddAdminServlet
 */
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
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
		String password = request.getParameter("password");
		Integer flag = Integer.valueOf(request.getParameter("flag"));

		PrintWriter out = response.getWriter();
		AdminService adminService = new AdminServiceImpl();
		
		// 判断此用户名是否已存在
		if(userName!=null && !"".equals(userName) && adminService.getAdminByName(userName)==null) {
			//不存在
			Admin admin = new Admin();
			admin.setUserName(userName);
			admin.setPassword(password);
			admin.setFlag(flag);
			admin.setIsUse(0);
			admin.setCreatTime(DateUtil.now());
			admin.setLoginTime(DateUtil.now());
			
			int recordNumber = adminService.addAdmin(admin);
			if(recordNumber == 1) {
				out.write("<script>alert('添加管理员成功！');"
						+ "window.location.href='pages/admin/right/addAdmin.jsp'</script>");
			} else {
				out.write("<script>alert('添加管理员失败！');"
						+ "window.location.href='pages/admin/right/addAdmin.jsp'</script>");
			}
			
		} else {
			// 存在
			out.write("<script>alert('该用户名已存在，请重新输入！');"
					+ "window.location.href='pages/admin/right/addAdmin.jsp'</script>");
		}
		
	}

}
