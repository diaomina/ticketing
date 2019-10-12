package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.domain.Pmember;
import com.cn.service.PmemberService;
import com.cn.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: UpdatePmemberAdminServlet 
 * @Description: 管理员 修改会员个人信息
 * @author: ljy
 * @date: 2019年9月30日 下午3:02:37
 */
public class UpdatePmemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePmemberAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 界面表单中获取数据
		Integer pmemberId = Integer.valueOf(request.getParameter("pmemberId"));
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String idCard = request.getParameter("idCard");
		
		// 从数据库中拉取原数据
		PmemberService pemeberService = new PmemberServiceImpl();
		Pmember pmember = pemeberService.getById(pmemberId);
		
		// 更新数据
		pmember.setRealName(realName);
		pmember.setSex(sex);
		pmember.setAge(age);
		pmember.setIdCard(idCard);
		
		int recordNumber = pemeberService.update(pmember);
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			out.write("<script>alert('修改成功！');"
			    + "window.location.href='MemberCenterServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,修改失败！');"
				    + "window.location.href='MemberCenterServlet'</script>");
		}
		out.close();
	}

}
