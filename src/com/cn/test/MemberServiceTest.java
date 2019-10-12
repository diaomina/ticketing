package com.cn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cn.domain.Member;
import com.cn.service.MemberService;
import com.cn.service.impl.MemberServiceImpl;

public class MemberServiceTest {

	@Test
	public void testAddMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemberById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemberByName() {
		MemberService merberService = new MemberServiceImpl();
		Member member = merberService.getMemberByName("lisi");
		System.out.println(member.toString());
	}

}
