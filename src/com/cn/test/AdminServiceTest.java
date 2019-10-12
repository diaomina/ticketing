package com.cn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cn.dao.impl.AdminDaoImpl;
import com.cn.domain.Admin;
import com.cn.service.AdminService;
import com.cn.service.impl.AdminServiceImpl;
import com.cn.util.DateUtil;

public class AdminServiceTest {
	private static AdminService adminService = new AdminServiceImpl(new AdminDaoImpl());

	@Test
	public void testAddAdmin() {
		Admin admin = new Admin("admin","fhjadhf34445",DateUtil.now(),1,1,DateUtil.now());
		int number = adminService.addAdmin(admin);
		System.out.println(number);
	}

	@Test
	public void testDeleteAdmin() {
		System.out.println(adminService.deleteAdmin(4));
	}

	@Test
	public void testUpdateAdmin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllAdmin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminByName() {
		fail("Not yet implemented");
	}

}
