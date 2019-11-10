package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Prep;
import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: UpdatePrepServlet 
 * @Description: 会员 判断是改签还是付款，如果是付款的话实现付款业务，改签的话跳转到ChangePrepServlet
 * @author: ljy
 * @date: 2019年11月10日 下午8:24:24
 */
public class UpdatePrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		Integer temp = Integer.valueOf(request.getParameter("temp"));
		
		PrepService prepService = new PrepServiceImpl();
		Prep prep = prepService.getById(prepId);
		
		// 付款业务
		if(temp == 1) {
			prep.setWay(true);
			int recordNumber = prepService.update(prep);
			if(recordNumber == 1) {
				request.setAttribute("msg", "付款成功！");
			} else {
				request.setAttribute("msg", "付款失败！");
			}
			request.getRequestDispatcher("MyPrepServlet").forward(request, response);
		}
		
		// 改签业务(先将prepId转发到ChangePrepServlet)
		if(temp == 2) {
			request.setAttribute("prepId", prepId);
			request.getRequestDispatcher("ChangePrepServlet").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
