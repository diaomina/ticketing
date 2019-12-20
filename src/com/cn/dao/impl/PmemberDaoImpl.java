package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.dao.PmemberDao;
import com.cn.domain.Pmember;
import com.cn.util.JDBCUtil;

/**
 * 
 * @ClassName: PmemberDaoImpl 
 * @Description: PmemberDao的实现类
 * @author: ljy
 * @date: 2019年9月14日 下午10:45:42
 */
public class PmemberDaoImpl implements PmemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;

	@Override
	public int add(Pmember pmember) throws SQLException {
		String sql = "insert into pmember (memberid,realname,sex,age,idcard) values (?,?,?,?,?)";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, pmember.getMemberId());
		pstmt.setObject(2, pmember.getRealName());
		pstmt.setObject(3, pmember.getSex());
		pstmt.setObject(4, pmember.getAge());
		pstmt.setObject(5, pmember.getIdCard());
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public int delete(Integer pmemberId) throws SQLException {
		String sql = "delete from pmember where pmemberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, pmemberId);
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public int update(Pmember pmember) throws SQLException {
		String sql = "update pmember set memberid=?,realname=?,sex=?,age=?,idcard=? where pmemberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, pmember.getMemberId());
		pstmt.setObject(2, pmember.getRealName());
		pstmt.setObject(3, pmember.getSex());
		pstmt.setObject(4, pmember.getAge());
		pstmt.setObject(5, pmember.getIdCard());
		pstmt.setObject(6, pmember.getPmemberId());
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public Pmember getPmemberByMemberId(Integer memberId) throws SQLException {
		String sql = "select * from pmember where memberId=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, memberId);
		rs = pstmt.executeQuery();
		Pmember pmember = null;
		while (rs.next()) {
			int pmemberId = rs.getInt("pmemberId");
			String realName = rs.getString("realName");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String idCard = rs.getString("idCard");
			pmember = new Pmember(pmemberId, memberId, realName, sex, age, idCard);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return pmember;
	}

	@Override
	public Pmember getById(Integer pmemberId) throws SQLException {
		String sql = "select * from pmember where pmemberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, pmemberId);
		rs = pstmt.executeQuery();
		Pmember pmember = null;
		while (rs.next()) {
			int memberId = rs.getInt("memberId");
			String realName = rs.getString("realName");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String idCard = rs.getString("idCard");
			pmember = new Pmember(pmemberId, memberId, realName, sex, age, idCard);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return pmember;
	}

}
