package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Admin;
import com.cn.service.AdminService;
import com.cn.service.impl.AdminServiceImpl;

/**
 * 
 * @ClassName: GetAllAmdinServlet 
 * @Description: 管理员  获取所有管理员
 * @author: ljy
 * @date: 2019年11月20日 下午12:55:22
 */
public class GetAllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private AdminService adminService = new AdminServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Admin> adminList = adminService.getAllAdmin();
		request.setAttribute("adminList", adminList);
		
		request.getRequestDispatcher("pages/admin/right/getAllAdmin.jsp").forward(request, response);
		
	}



}
