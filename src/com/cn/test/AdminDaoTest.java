package com.cn.test;

import java.sql.SQLException;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.domain.Admin;
import com.cn.util.DateUtil;

public class AdminDaoTest {

	public static void main(String[] args) {
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = new Admin("打飞机阿卡","123456",DateUtil.now(),1,1,DateUtil.now());
		try {
			adminDao.add(admin);
			for(Admin admin2:adminDao.getAll()) {
				System.out.println(admin2);
			}
			System.out.println(adminDao.getById(4));
			System.out.println(adminDao.getByName("lxs"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
