package com.cn.service;

import java.util.List;

import com.cn.domain.Admin;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月13日
 */
public interface AdminService {
	int addAdmin(Admin admin);

	int deleteAdmin(int adminId);

	int updateAdmin(Admin admin);

	List<Admin> getAllAdmin();

	Admin getAdminById(int adminId);

	Admin getAdminByName(String userName);
}
