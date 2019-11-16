package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Prep;
import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: GetAllPrepServlet 
 * @Description: 管理员  订单中心
 * @author: ljy
 * @date: 2019年11月16日 下午7:44:25
 */
public class GetAllPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrepService prepService = new PrepServiceImpl();
		List<Prep> prepList = prepService.getAll();
		request.setAttribute("prepList", prepList);
		request.getRequestDispatcher("pages/admin/right/prepCenter.jsp").forward(request, response);
	}



}
