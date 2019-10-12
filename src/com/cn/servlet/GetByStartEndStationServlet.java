package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Train;
import com.cn.service.TrainService;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: GetByStartEndStationServlet 
 * @Description: 会员查询车次的Servlet
 * @author: ljy
 * @date: 2019年9月11日 下午4:41:33
 */
public class GetByStartEndStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetByStartEndStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 先执行，将所有车次信息展示到界面
		 */
		TrainService trainService = new TrainServiceImpl();
		List<Train> startStationList = trainService.getAllStartStation();
		if(startStationList != null) {
			request.setAttribute("startStationList", startStationList);
		}else {
			request.setAttribute("msg", "初始站站点为空");
		}
		
		List<Train> endStationList = trainService.getAllEndStation();
		if(endStationList != null) {
			request.setAttribute("endStationList", endStationList);
		}else {
			request.setAttribute("msg", "终点站站点为空");
		}
		
		List<Train> trainList = trainService.getAll();
		if(trainList != null) {
			request.setAttribute("trainList", trainList);
		}else {
			request.setAttribute("msg", "没有任何站点信息");
		}
		
		String msg = (String) request.getSession().getAttribute("msg");
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("pages/user/getByStartEndStation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 后执行，处理会员查询车次信息业务，将查询结果展示到界面
		 */
		String startStation = request.getParameter("startStation");
		String endStation = request.getParameter("endStation");
		String startTime = request.getParameter("startTime");
		
		TrainService trainService = new TrainServiceImpl();
		List<Train> startStationList = trainService.getAllStartStation();
		
		
		
		// 将站点列表传到界面，否则下拉框将没有站点
		if(startStationList != null) {
			request.setAttribute("startStationList", startStationList);
		}else {
			//request.setAttribute("msg", "初始站站点为空");
			request.getSession().setAttribute("msg", "初始站站点为空");
		}
		
		List<Train> endStationList = trainService.getAllEndStation();
		if(endStationList != null) {
			request.setAttribute("endStationList", endStationList);
		}else {
			//request.setAttribute("msg", "终点站站点为空");
			request.getSession().setAttribute("msg", "终点站站点为空");
		}
		
		
		List<Train> list = trainService.getByStartEndStation(startStation, endStation, startTime);
		
		PrintWriter out = response.getWriter();
		
		// 判断是否查询到车次
		if(list!=null && list.size()>0) {
			// 查到了，将结果转发到界面
			request.setAttribute("trainList", list);
			request.getRequestDispatcher("pages/user/getByStartEndStation.jsp").forward(request, response);
		} else {
			// 没有查到
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			
			String path = "<script>alert('很抱歉，没有查询到车次！');"
				    + "window.location.href='"+basePath+"GetByStartEndStationServlet'</script>";
			
			out.write(path);
		}
		
		out.close();

	}

}
