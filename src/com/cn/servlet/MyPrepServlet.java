package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Member;
import com.cn.domain.Pmember;
import com.cn.domain.Prep;
import com.cn.service.PmemberService;
import com.cn.service.PrepService;
import com.cn.service.impl.PmemberServiceImpl;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: MyPrepServlet 
 * @Description: 用户 我的订单
 * @author: ljy
 * @date: 2019年9月29日 下午3:30:45
 */
public class MyPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPrepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member member = (Member) request.getSession().getAttribute("member");
		PmemberService pmemberService = new PmemberServiceImpl();
		Pmember pmember = pmemberService.getPmemberByMemberId(member.getMemberId());
		PrepService prepService = new PrepServiceImpl();
		List<Prep> prepList = prepService.getPrepByPmemberId(pmember.getPmemberId());
		if(prepList!=null && prepList.size()>0) {
			request.setAttribute("prepList", prepList);
		} else {
			request.setAttribute("msg", "您没有任何订单！");
		}
		
		request.getRequestDispatcher("pages/user/myCenter/right/myPrep.jsp").forward(request, response);
		
	}



}
