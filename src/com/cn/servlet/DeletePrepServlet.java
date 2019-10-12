package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;
import com.sun.org.apache.regexp.internal.REUtil;

/**
 * 
 * @ClassName: DeletePrepServlet 
 * @Description: 删除订单
 * @author: ljy
 * @date: 2019年9月28日 下午7:25:16
 */
public class DeletePrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePrepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrepService prepService = new PrepServiceImpl();
		int recordNumber = 0;
		
		Integer prepId = (Integer) request.getAttribute("prepId");
		if(prepId != null) {
			// 这是从UpdatePrepServlet过来的，实现改签业务
			recordNumber = prepService.delete(prepId);
			
			PrintWriter out = response.getWriter();
			if(recordNumber == 1) {
				// 将改签开始的信息存到session，告知BookingServlet这是改签
				request.getSession().setAttribute("changePrep", "true");
				
				// 跳转
				out.write("<script>alert('请您选择新的车次！');"
					    + "window.location.href='GetByStartEndStationServlet'</script>");
			} else {
				out.write("<script>alert('很抱歉,改签失败！');"
					    + "window.location.href='MyPrepServlet'</script>");
			}
			
		} else {
			// 这是从界面过来的，实现退票业务
			prepId = Integer.valueOf(request.getParameter("prepId"));
			recordNumber = prepService.delete(prepId);
			
			PrintWriter out = response.getWriter();
			if(recordNumber == 1) {
				out.write("<script>alert('退票成功！');"
				    + "window.location.href='MyPrepServlet'</script>");
			}else {
				out.write("<script>alert('很抱歉,退票失败！');"
					    + "window.location.href='MyPrepServlet'</script>");
			}
			
			out.close();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
