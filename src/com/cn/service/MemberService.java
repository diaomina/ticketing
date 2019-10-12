package com.cn.service;

import java.util.List;

import com.cn.domain.Member;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月13日
 */
public interface MemberService {
	int addMember(Member member);
	
	int deleteMember(int memberId);
	
	int updateMember(Member member);
	
	List<Member> getAllMember();
	
	Member getMemberById(int memberId);
	
	Member getMemberByName(String userName);
}
