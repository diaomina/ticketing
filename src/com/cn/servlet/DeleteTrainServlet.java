package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.TrainService;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: DeleteTrainServlet 
 * @Description: 管理员  删除车次
 * @author: ljy
 * @date: 2019年11月18日 下午11:38:41
 */
public class DeleteTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTrainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer trainId = Integer.valueOf(request.getParameter("trainId"));
		TrainService trainService = new TrainServiceImpl();
		int recordNumber = trainService.delete(trainId);
		
		/**
		 * 	根据返回值判断是否删除车次成功，返回1为成功
		 */
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('删除成功！');"
			    + "window.location.href='GetAllTrainServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,删除失败！');"
				    + "window.location.href='GetAllTrainServlet'</script>");
		}
		
		out.close();
		//response.sendRedirect("GetAllTrainServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer trainId = Integer.valueOf(request.getParameter("trainId"));
		TrainService trainService = new TrainServiceImpl();
		int recordNumber = trainService.delete(trainId);
		
		/**
		 * 	根据返回值判断是否删除车次成功，返回1为成功
		 */
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('删除成功！');"
			    + "window.location.href='GetAllTrainServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,删除失败！');"
				    + "window.location.href='GetAllTrainServlet'</script>");
		}
		
		out.close();
	}

}
