package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.domain.Member;

/**
 * 
 * @ClassName: CheckLoginServlet
 * @Description: 校验会员是否登录
 * @author: ljy
 * @date: 2019年11月23日 下午1:01:53
 */
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String temp = request.getParameter("temp");

		// 判断是否已经登录
		if (member != null) {
			// 登陆了
			
			if("1".equals(temp)) {
				// 跳转到会员中心界面
				response.sendRedirect("pages/user/myCenter/myCenter.jsp");
			}
			
			if("2".equals(temp)) {
				// 跳转到订票的Servlet
				Integer trainId = Integer.valueOf(request.getParameter("trainId"));
				request.setAttribute("trainId", trainId);
				request.getRequestDispatcher("BookingServlet").forward(request, response);
			}
			

		} else {
			// 没有登录，跳转到会员登录界面
			PrintWriter out = response.getWriter();
			out.write("<script>alert('您还没有登录，请先登录！');window.location.href='pages/user/memberLogin.jsp'</script>");
			out.close();
		}
	}

}
