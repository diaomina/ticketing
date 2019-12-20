package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public int add(Admin admin) throws SQLException {
		String sql = "insert into admins (username,password,creattime,flag,isuse,logintime) VALUES (?,?,?,?,?,?)";

		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, admin.getUserName());
		pstmt.setObject(2, admin.getPassword());
		pstmt.setObject(3, admin.getCreatTime());
		pstmt.setObject(4, admin.getFlag());
		pstmt.setObject(5, admin.getIsUse());
		pstmt.setObject(6, admin.getLoginTime());
		// 执行添加语句
		int status = pstmt.executeUpdate();
		// 关流
		pstmt.close();
		conn.close();
		
		return status;
	}

	@Override
	public int delete(int adminId) throws SQLException {
		String sql = "delete from admins where adminid=?";
		
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, adminId);
		// 执行删除语句
		int status = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return status;
	}

	
	@Override
	public int update(Admin admin) throws SQLException {
		String sql = "update admins set username=?,password=?,flag=?,isuse=?,logintime=? where adminid=?";
		
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, admin.getUserName());
		pstmt.setObject(2, admin.getPassword());
		pstmt.setObject(3, admin.getFlag());
		pstmt.setObject(4, admin.getIsUse());
		pstmt.setObject(5, admin.getLoginTime());
		pstmt.setObject(6, admin.getAdminId());
		
		int status = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return status;
	}

	@Override
	public Admin getById(int adminId) throws SQLException {
		String sql = "select * from admins where adminid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, adminId);
		rs = pstmt.executeQuery();
		Admin admin = null;
		while (rs.next()) {
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			Timestamp creatTime = rs.getTimestamp("creatTime");
			int flag = rs.getInt("flag");
			int isUse = rs.getInt("isUse");
			Timestamp loginTime = rs.getTimestamp("loginTime");
			admin = new Admin(adminId, userName, password, creatTime, flag, isUse, loginTime);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return admin;
	}

	@Override
	public List<Admin> getAll() throws SQLException{
		String sql = "select * from admins";
		
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Admin> admins = new ArrayList<Admin>();
		while (rs.next()) {
			int adminId = rs.getInt("adminId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			Timestamp creatTime = rs.getTimestamp("creatTime");
			int flag = rs.getInt("flag");
			int isUse = rs.getInt("isUse");
			Timestamp loginTime = rs.getTimestamp("loginTime");
			Admin admin = new Admin(adminId, userName, password, creatTime, flag, isUse, loginTime);
			admins.add(admin);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return admins;
	}

	@Override
	public Admin getByName(String userName) throws SQLException {
		String sql = "select * from admins where username=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, userName);
		rs = pstmt.executeQuery();
		Admin admin = null;
		while (rs.next()) {
			int adminId = rs.getInt("adminId");
			String password = rs.getString("password");
			Timestamp creatTime = rs.getTimestamp("creatTime");
			int flag = rs.getInt("flag");
			int isUse = rs.getInt("isUse");
			Timestamp loginTime = rs.getTimestamp("loginTime");
			admin = new Admin(adminId, userName, password, creatTime, flag, isUse, loginTime);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return admin;
	}
}
