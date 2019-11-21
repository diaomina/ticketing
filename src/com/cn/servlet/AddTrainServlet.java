package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Train;
import com.cn.service.TrainService;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: AddTrainServlet 
 * @Description: 添加车次的Servlet
 * @author: ljy
 * @date: 2019年9月11日 下午4:41:06
 */
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 	获取界面中输入的数据
		 */
		String trainNumber = request.getParameter("trainNumber");
		String startStation = request.getParameter("startStation");
		String endStation = request.getParameter("endStation");
		String startTime = request.getParameter("startTime");
		startTime = startTime.substring(0, 10)+" "+startTime.substring(11)+":00";
		String endTime = request.getParameter("endTime");
		endTime = endTime.substring(0, 10)+" "+endTime.substring(11)+":00";
		Integer price = Integer.valueOf(request.getParameter("price"));
		Integer seatNumber = Integer.valueOf(request.getParameter("seatNumber"));
		// 获取当前时间
		Timestamp addTime = new Timestamp(new Date().getTime());
		
		/**
		 * 	将数据封装成对象
		 */
		Train train = new Train();
		train.setTrainNumber(trainNumber);
		train.setStartStation(startStation);
		train.setEndStation(endStation);
		train.setStartTime(startTime);
		train.setEndTime(endTime);
		train.setPrice(price);
		train.setSeatNumber(seatNumber);
		train.setAddTime(addTime);
		
		/**
		 * 	将数据存入数据库,并返回是否成功的结果
		 */
		TrainService trainService = new TrainServiceImpl();
		int recordNumber = trainService.add(train);
		
		/**
		 * 	根据返回值判断是否添加车次成功，返回1为成功
		 */
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('添加成功！');"
			    + "window.location.href='GetAllTrainServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,添加失败！');"
				    + "window.location.href='pages/admin/right/addTrain.jsp'</script>");
		}
		
		out.close();
		//response.sendRedirect("pages/admin/right/addTrain.jsp");
		
	}

}
