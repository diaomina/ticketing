package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cn.dao.AdminDao;
import com.cn.domain.Admin;
import com.cn.util.JDBCUtil;

/**
 * @className AdminDaoImpl
 * @description
 * @author lxs
 * @date 2019年9月1日
 */
public class AdminDaoImpl implements AdminDao {
	private Connection conn = null;
	private QueryRunner queryRunner = null;

	@Override
	public int add(Admin admin) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "insert into admins (username,password,creattime,flag,isuse,logintime) VALUES (?,?,?,?,?,?)";
		int status = queryRunner.update(conn, sql, admin.getUserName(), admin.getPassword(),
				admin.getCreatTime(), admin.getFlag(), admin.getIsUse(), admin.getLoginTime());
//		int status = queryRunner.update(conn, sql);
		DbUtils.close(conn);
		return status;
	}

	@Override
	public int delete(int adminId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int status = queryRunner.update(conn,"delete from admins where adminid=?", adminId);
		DbUtils.close(conn);
		return status;
	}

	
	@Override
	public int update(Admin admin) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int status = queryRunner.update(conn,"update admins set username=?,password=?,flag=?,isuse=?,logintime=? where adminid=?", 
				admin.getUserName(), admin.getPassword(), admin.getFlag(), admin.getIsUse(), admin.getLoginTime(), admin.getAdminId());
		DbUtils.close(conn);
		return status;
	}

	@Override
	public Admin getById(int adminId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		Admin admin = queryRunner.query(conn,"select * from admins where adminid=?", new BeanHandler<Admin>(Admin.class), adminId);
		DbUtils.close(conn);
		return admin;
	}

	@Override
	public List<Admin> getAll() throws SQLException{
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Admin> list = queryRunner.query(conn,"select * from admins", new BeanListHandler<Admin>(Admin.class));
		DbUtils.close(conn);
		return list;
	}

	@Override
	public Admin getByName(String userName) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		Admin admin = queryRunner.query(conn,"select * from admins where username=?", new BeanHandler<Admin>(Admin.class), userName);
		DbUtils.close(conn);
		return admin;
	}
}
