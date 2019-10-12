package com.cn.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.domain.Admin;
import com.cn.service.AdminService;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月13日
 */
public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = null;

	public AdminServiceImpl(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public AdminServiceImpl() {
	}

	@Override
	public int addAdmin(Admin admin) {
		int status = 0;
		adminDao = new AdminDaoImpl();
		try {
			status = adminDao.add(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteAdmin(int adminId) {
		int status = 0;
		adminDao = new AdminDaoImpl();
		try {
			status = adminDao.delete(adminId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateAdmin(Admin admin) {
		int status = 0;
		adminDao = new AdminDaoImpl();
		try {
			status = adminDao.update(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list = null;
		adminDao = new AdminDaoImpl();
		try {
			list = adminDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin getAdminById(int adminId) {
		Admin admin = null;
		adminDao = new AdminDaoImpl();
		try {
			admin = adminDao.getById(adminId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public Admin getAdminByName(String userName) {
		Admin admin = null;
		adminDao = new AdminDaoImpl();
		try {
			admin = adminDao.getByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

}
