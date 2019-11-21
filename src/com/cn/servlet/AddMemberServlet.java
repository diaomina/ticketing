package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.MemberDao;
import com.cn.dao.impl.MemberDaoImpl;
import com.cn.domain.Member;
import com.cn.domain.Pmember;
import com.cn.service.MemberService;
import com.cn.service.PmemberService;
import com.cn.service.impl.MemberServiceImpl;
import com.cn.service.impl.PmemberServiceImpl;
import com.cn.util.DateUtil;

/**
 * 
 * @ClassName: AddMemberServlet 
 * @Description: 管理员 添加会员操作
 * @author: ljy
 * @date: 2019年9月30日 下午5:11:36
 */
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberServlet() {
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
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		MemberDao memberDao = new MemberDaoImpl();
		MemberService memberService = new MemberServiceImpl(memberDao);
		
		PrintWriter out = response.getWriter();
		//校验用户名是否已经存在
		if(memberService.getMemberByName(userName) == null) {
			// 不存在，可以创建
			
			// 创建账户，将信息添加到member表
			Member member = new Member(userName, password, DateUtil.now(), 0, DateUtil.now());
			int countNumber = memberService.addMember(member);
			
			if(countNumber == 1) {
				
				// 将个人信息存储到pmember
				Pmember pmember = new Pmember();
				Integer memberId = memberService.getMemberByName(userName).getMemberId();
				pmember.setMemberId(memberId);
				
				String realName = request.getParameter("realName");
				String sex = request.getParameter("sex");
				Integer age = Integer.valueOf(request.getParameter("age"));
				String idCard = request.getParameter("idCard");
				
				pmember.setRealName(realName);
				pmember.setSex(sex);
				pmember.setAge(age);
				pmember.setIdCard(idCard);
				
				PmemberService pmemberService = new PmemberServiceImpl();
				pmemberService.add(pmember);
				
				out.write("<script>alert('添加会员成功！');window.location.href='MemberCenterServlet'</script>");
			} else {
				out.write("<script>alert('添加会员失败！');window.location.href='pages/admin/right/addMember.jsp'</script>");
			}
			
		} else {
			// 存在
			out.write("<script>alert('用户名已存在，请重新输入！');window.location.href='pages/admin/right/addMember.jsp'</script>");
		}
		
		out.close();
	}

}
