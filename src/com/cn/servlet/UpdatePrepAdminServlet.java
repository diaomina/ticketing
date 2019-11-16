package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Prep;
import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: UpdatePrepAdminServlet 
 * @Description: 管理员 修改订单
 * @author: ljy
 * @date: 2019年9月28日 下午7:38:31
 */
public class UpdatePrepAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取订单信息转发到修改订单界面
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		
		PrepService prepService = new PrepServiceImpl();
		Prep prep = prepService.getById(prepId);
		
		request.setAttribute("prep", prep);
		
		request.getRequestDispatcher("pages/admin/right/updatePrep.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取修改界面的数据，将其刷新进数据库
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		Integer price = Integer.valueOf(request.getParameter("price"));
		boolean way = Boolean.valueOf(request.getParameter("way"));
		
		PrepService prepService = new PrepServiceImpl();
		Prep prep = prepService.getById(prepId);
		
		prep.setPrice(price);
		prep.setWay(way);
		
		int recordNumber = prepService.update(prep);
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('修改成功！');"
			    + "window.location.href='GetAllPrepServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,修改失败！');"
				    + "window.location.href='GetAllPrepServlet'</script>");
		}
		
		out.close();
		
	}

}
