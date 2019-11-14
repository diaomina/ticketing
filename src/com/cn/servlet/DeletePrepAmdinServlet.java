package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: DeletePrepServlet 
 * @Description: 管理员删除订单
 * @author: ljy
 * @date: 2019年9月28日 下午7:25:16
 */
public class DeletePrepAmdinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePrepAmdinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer prepId = (Integer) request.getAttribute("prepId");
		
		PrepService prepService = new PrepServiceImpl();
		int recordNumber = 0;

		// 这是从管理员界面过来的，实现删除订单业务
		prepId = Integer.valueOf(request.getParameter("prepId"));
		recordNumber = prepService.delete(prepId);
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('删除订单成功！');"
			    + "window.location.href='GetAllPrepServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,删除失败！');"
				    + "window.location.href='GetAllPrepServlet'</script>");
		}
		
		out.close();
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
