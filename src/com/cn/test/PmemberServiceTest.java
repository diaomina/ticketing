package com.cn.test;

import java.util.List;

import org.junit.Test;

import com.cn.domain.Pmember;
import com.cn.service.PmemberService;
import com.cn.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: PmemberServiceTest 
 * @Description: PmemberService接口的测试类
 * @author: ljy
 * @date: 2019年9月16日 下午10:52:30
 */
public class PmemberServiceTest {
	
	private PmemberService pmemberService = new PmemberServiceImpl();

	@Test
	public void testAdd() {
		Pmember pmember = new Pmember();
		pmember.setMemberId(2);
		pmember.setRealName("李1");
		pmember.setAge(22);
		pmember.setSex("女");
		pmember.setIdCard("360420199902063514");
		int recordNumber = pmemberService.add(pmember);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = pmemberService.delete(5);
		System.out.println(recordNumber);
	}

	@Test
	public void testUpdate() {
		Pmember pmember = new Pmember();
		pmember.setPmemberId(3);
		pmember.setMemberId(2);
		pmember.setRealName("李1");
		pmember.setAge(33);
		pmember.setSex("女");
		pmember.setIdCard("360420199902063514");
		int recordNumber = pmemberService.update(pmember);
		System.out.println(recordNumber);
	}

	@Test
	public void testGetPmemberByMemberId() {
		Pmember pmember = pmemberService.getPmemberByMemberId(2);
			System.out.println(pmember.toString());
	}

	@Test
	public void testGetById() {
		Pmember pmember = pmemberService.getById(4);
		System.out.println(pmember.toString());
	}

}
