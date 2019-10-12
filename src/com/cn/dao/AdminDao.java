package com.cn.dao;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Admin;

/**
 * @className AdminDao.java
 * @description
 * @author lxs
 * @date 2019年9月1日
 */
public interface AdminDao {
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	int add(Admin admin) throws SQLException;
	
	/**
	 * 删除管理员
	 * @param adminId
	 * @return
	 * @throws SQLException
	 */
	int delete(int adminId) throws SQLException;
	
	/**
	 * 修改管理员
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	int update(Admin admin) throws SQLException;
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	List<Admin> getAll() throws SQLException;
	
	/**
	 * 通过id查询管理员信息
	 * @param adminId
	 * @return
	 * @throws SQLException
	 */
	Admin getById(int adminId) throws SQLException;
	
	/**
	 * 通过管理员姓名查询
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	Admin getByName(String userName) throws SQLException;
}
