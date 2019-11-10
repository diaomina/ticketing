package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Train;
import com.cn.service.TrainService;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: UpdateTrainServlet 
 * @Description: 管理员 修改车次信息
 * @author: ljy
 * @date: 2019年11月10日 下午11:49:16
 */
public class UpdateTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 	将需要修改的车次信息输出到界面
		 */
		Integer trainId = Integer.valueOf(request.getParameter("trainId"));
		TrainService trainService = new TrainServiceImpl();
		Train train = trainService.getById(trainId);
		//开车时间与到站时间格式转换为"yyyy-MM-ddThh:mm"，不然jsp界面无法显示出默认时间
		String startTime = train.getStartTime();
		startTime = startTime.substring(0, 10)+"T"+startTime.substring(11, 16);
		train.setStartTime(startTime);
		String endTime = train.getEndTime();
		endTime = endTime.substring(0, 10)+"T"+endTime.substring(11, 16);
		train.setEndTime(endTime);
		
		request.setAttribute("train", train);
		request.getRequestDispatcher("pages/admin/right/updateTrain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 	将修改后的车次信息保存到数据库，然后跳转到GetAllTrainServlet界面
		 */
		
		
		//获取界面中输入的数据
		Integer trainId = Integer.valueOf(request.getParameter("trainId"));
		String trainNumber = request.getParameter("trainNumber");
		String startStation = request.getParameter("startStation");
		String endStation = request.getParameter("endStation");
		String startTime = request.getParameter("startTime");
		startTime = startTime.substring(0, 10)+" "+startTime.substring(11)+":00";
		String endTime = request.getParameter("endTime");
		endTime = endTime.substring(0, 10)+" "+endTime.substring(11)+":00";
		Integer price = Integer.valueOf(request.getParameter("price"));
		Integer seatNumber = Integer.valueOf(request.getParameter("seatNumber"));
		
		//从数据库中取出该车次信息，进行修改
		TrainService trainService = new TrainServiceImpl();
		Train train = trainService.getById(trainId);
		
		train.setTrainNumber(trainNumber);
		train.setStartStation(startStation);
		train.setEndStation(endStation);
		train.setStartTime(startTime);
		train.setEndTime(endTime);
		train.setPrice(price);
		train.setSeatNumber(seatNumber);
		
		//将数据存入数据库,并返回是否成功的结果
		int recordNumber = trainService.update(train);
		
		
		//根据返回值判断是否添加车次成功，返回1为成功
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('修改成功！');"
			    + "window.location.href='GetAllTrainServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,修改失败！');"
				    + "window.location.href='GetAllTrainServlet'</script>");
		}
		
		out.close();
		
	}

}
