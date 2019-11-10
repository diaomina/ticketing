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
 * @ClassName: UpdatePmemberServlet 
 * @Description: 会员 修改会员个人信息
 * @author: ljy
 * @date: 2019年9月30日 下午2:42:24
 */
public class UpdatePmemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
					    + "window.location.href='GetPmemberByMemberIdServlet'</script>");
				}else {
					out.write("<script>alert('很抱歉,修改失败！');"
						    + "window.location.href='GetPmemberByMemberIdServlet'</script>");
				}
				out.close();
	}

}
