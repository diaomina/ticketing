package com.cn.test;

import java.sql.SQLException;

import com.cn.dao.MemberDao;
import com.cn.dao.impl.MemberDaoImpl;
import com.cn.domain.Member;
import com.cn.util.DateUtil;

public class MemberDaoTest {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDaoImpl();
		//Member member = new Member("ljy","123456",DateUtil.now(),0,DateUtil.now());
		try {
//			System.out.println(memberDao.add(member));
//			System.out.println(memberDao.delete(2));
			for(Member member2:memberDao.getAll()) {
				System.out.println(member2);
			}
//			System.out.println(memberDao.getMemberById(2));
			System.out.println(memberDao.getMemberByName("lisi"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
