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

import cn.hutool.crypto.SecureUtil;

public class RegMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		// md5加密
		//String password = SecureUtil.md5(passwd);
		
		
		MemberDao memberDao = new MemberDaoImpl();
		MemberService memberService = new MemberServiceImpl(memberDao);
		
		//////////校验用户名是否已经存在，待写/////////
		
		Member member = new Member(userName, password, DateUtil.now(), 0, DateUtil.now());
		int countNumber = memberService.addMember(member);
		
		PrintWriter out = response.getWriter();
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
			
			out.write("<script>alert('注册成功，点击登录！');window.location.href='pages/user/memberLogin.jsp'</script>");
		} else {
			out.write("<script>alert('注册失败！');window.location.href='pages/user/memberReg.jsp'</script>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
