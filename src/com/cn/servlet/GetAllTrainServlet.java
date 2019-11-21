package com.cn.servlet;

import java.io.IOException;
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
 * @ClassName: GetAllTrainServlet 
 * @Description: 获取所有车次信息的Servlet
 * @author: ljy
 * @date: 2019年9月11日 下午4:45:31
 */
public class GetAllTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllTrainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainService trainService = new TrainServiceImpl();
		List<Train> trainList = trainService.getAll();
		if(trainList != null) {
			request.setAttribute("trainList", trainList);
		}else {
			System.out.println("没有任何站点信息");
		}
		
		request.getRequestDispatcher("pages/admin/right/getAllTrain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
