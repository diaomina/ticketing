package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Train;
import com.cn.service.PrepService;
import com.cn.service.TrainService;
import com.cn.service.impl.PrepServiceImpl;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: ChangePrepServlet
 * @Description: 会员 改签业务
 * @author: ljy
 * @date: 2019年9月30日 下午5:53:36
 */
public class ChangePrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// prepId这是从UpdatePrepServlet过来的，实现改签业务，
		Integer prepId = (Integer) request.getAttribute("prepId");
		
		PrepService prepService = new PrepServiceImpl();
		TrainService trainService = new TrainServiceImpl();
		// 将订单信息中的trainID先拉取出来，下面更改车次座位数需要
		Integer trainId = prepService.getById(prepId).getTrainId();
		
		// 删除这个订单
		int recordNumber = 0;
		recordNumber = prepService.delete(prepId);

		PrintWriter out = response.getWriter();
		if (recordNumber == 1) {
			// 座位数+1
			Train train = trainService.getById(trainId);
			train.setSeatNumber(train.getSeatNumber() + 1);
			trainService.update(train);

			// 将改签开始的信息存到session，告知BookingServlet这是改签
			request.getSession().setAttribute("changePrep", "true");

			// 跳转
			out.write("<script>alert('请您选择新的车次！');" + 
					"window.location.href='GetByStartEndStationServlet'</script>");
		} else {
			out.write("<script>alert('很抱歉,改签失败！');" + 
					"window.location.href='MyPrepServlet'</script>");
		}
	}


}
