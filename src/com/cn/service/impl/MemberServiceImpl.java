package com.cn.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cn.dao.MemberDao;
import com.cn.dao.impl.MemberDaoImpl;
import com.cn.domain.Member;
import com.cn.service.MemberService;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月13日
 */
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = null;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public MemberServiceImpl() {
	}

	@Override
	public int addMember(Member member) {
		int status = 0;
		memberDao = new MemberDaoImpl();
		if (member != null) {
			try {
				status = memberDao.add(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int deleteMember(int memberId) {
		int status = 0;
		memberDao = new MemberDaoImpl();
		try {
			status = memberDao.delete(memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateMember(Member member) {
		int status = 0;
		memberDao = new MemberDaoImpl();
		if (member != null) {
			try {
				status = memberDao.update(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public List<Member> getAllMember() {
		List<Member> list = null;
		memberDao = new MemberDaoImpl();
		try {
			list = memberDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Member getMemberById(int memberId) {
		Member member = null;
		memberDao = new MemberDaoImpl();
		try {
			member = memberDao.getMemberById(memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public Member getMemberByName(String userName) {
		Member member = new Member();
		memberDao = new MemberDaoImpl();
		try {
			member = memberDao.getMemberByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

}
