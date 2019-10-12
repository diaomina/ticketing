package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Pmember;
import com.cn.service.PmemberService;
import com.cn.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: GetPmemberByPmemberIdServlet 
 * @Description: 根据pmemberId获取会员个人信息
 * @author: ljy
 * @date: 2019年9月21日 上午2:45:08
 */
public class GetPmemberByPmemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPmemberByPmemberIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pmemberId = Integer.valueOf(request.getParameter("pmemberId"));
		PmemberService pmemberService = new PmemberServiceImpl();
		Pmember pmember = pmemberService.getById(pmemberId);
		if(pmember != null) {
			request.setAttribute("pmember", pmember);
		} else {
			request.setAttribute("msg", "没有个人信息！");
		}
		
		request.getRequestDispatcher("pages/admin/right/pmember.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
