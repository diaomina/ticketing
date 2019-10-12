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

/**
 * 
 * @ClassName: UpdateAdminPassword 
 * @Description: 修改管理员密码
 * @author: ljy
 * @date: 2019年9月29日 下午11:45:50
 */
public class UpdateAdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminPassword() {
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
		
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		
		PrintWriter out = response.getWriter();
		
		// 先判断原密码是否正确
		if(oldPassword!=null && oldPassword.equals(admin.getPassword())) {
			// 原密码正确
			admin.setPassword(newPassword);
			AdminService adminService = new AdminServiceImpl();
			int recordNumber = adminService.updateAdmin(admin);
			
			if(recordNumber == 1) {
				out.write("<script>alert('修改密码成功！');"
				    + "window.self.href='pages/admin/adminMain.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉,修改密码失败！');"
					    + "window.self.href='pages/admin/adminMain.jsp'</script>");
			}	
			
		} else {
			// 原密码错误
			out.write("<script>alert('原密码错误，请重新输入！');"
				    + "window.self.href='pages/admin/adminMain.jsp'</script>");
		}
		
		out.close();
		
	}

}
