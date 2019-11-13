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
 * @ClassName: PayServlet 
 * @Description: 用户付款
 * @author: ljy
 * @date: 2019年9月28日 下午10:38:37
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp = request.getParameter("temp");
		
		// 判断是否是从支付宝支付接口回跳来的
		if(temp != null && "1".equals(temp)) {
			Integer prepId = Integer.valueOf(request.getParameter("prepId"));
			PrepService prepService = new PrepServiceImpl();
			Prep prep = prepService.getById(prepId);
			
			prep.setWay(true);
			int recordNumber = prepService.update(prep);
			
			PrintWriter out = response.getWriter();
			if(recordNumber == 1) {
				out.write("<script>alert('付款成功！');"
				    + "window.location.href='pages/user/myCenter/myCenter.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉,付款失败！');"
					    + "window.location.href='MyPrepServlet'</script>");
			}
			
			out.close();
			
		}
		
		
		
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		PrepService prepService = new PrepServiceImpl();
		Prep prep = prepService.getById(prepId);
		
		// 支付接口调用   start
		
		request.setAttribute("prep", prep);
		request.getRequestDispatcher("AlipayServlet").forward(request, response);
		
		// 支付接口调用   end
		
		/*
		 * prep.setWay(true); int recordNumber = prepService.update(prep);
		 * 
		 * PrintWriter out = response.getWriter(); if(recordNumber == 1) {
		 * out.write("<script>alert('付款成功！');" +
		 * "window.location.href='MyPrepServlet'</script>"); }else {
		 * out.write("<script>alert('很抱歉,付款失败！');" +
		 * "window.location.href='MyPrepServlet'</script>"); }
		 * 
		 * out.close();
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
