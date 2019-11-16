package com.cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * @ClassName: CountPrepServlet 
 * @Description: 管理来员 销售统计
 * @author: ljy
 * @date: 2019年11月16日 下午4:38:07
 */
public class CountPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PrepService prepService = new PrepServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 所有订单
		List<Prep> list = prepService.getAll();
		// 已付款的订单
		List<Prep> preps = new ArrayList<Prep>();
		
		for(Prep prep : list) {
			if(prep.isWay()) {
				preps.add(prep);
			}
		}
		
		// 统计
		Integer prepNumber = preps.size();	// 有效订单数
		Integer prepPrice = 0;	// 总销售额
		for(Prep prep : preps) {
			prepPrice += prep.getPrice();
		}
		
		
		request.setAttribute("prepNumber", prepNumber);
		request.setAttribute("prepPrice", prepPrice);
		request.getRequestDispatcher("pages/admin/right/countPrep.jsp").forward(request, response);
		
	}



}
