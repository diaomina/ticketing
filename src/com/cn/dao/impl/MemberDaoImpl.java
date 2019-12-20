package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.MemberDao;
import com.cn.domain.Member;
import com.cn.util.JDBCUtil;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月8日
 */
public class MemberDaoImpl implements MemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;

	@Override
	public int add(Member member) throws SQLException {
		String sql = "insert into member(username,password,registertime,ifuse,logintimes) values(?,?,?,?,?)";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, member.getUserName());
		pstmt.setObject(2, member.getPassword());
		pstmt.setObject(3, member.getRegisterTime());
		pstmt.setObject(4, member.getIfUse());
		pstmt.setObject(5, member.getLogintimes());
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public int delete(int memberId) throws SQLException {
		String sql = "delete from member where memberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, memberId);
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public int update(Member member) throws SQLException {
		String sql = "update member set username=?,password=?,ifuse=?,logintimes=? where memberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, member.getUserName());
		pstmt.setObject(2, member.getPassword());
		pstmt.setObject(3, member.getIfUse());
		pstmt.setObject(4, member.getLogintimes());
		pstmt.setObject(5, member.getMemberId());
		int status = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return status;
	}

	@Override
	public List<Member> getAll() throws SQLException {
		String sql = "select * from member";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Member> members = new ArrayList<Member>();
		while (rs.next()) {
			int memberId = rs.getInt("memberId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			Timestamp registerTime = rs.getTimestamp("registerTime");
			int ifUse = rs.getInt("ifUse");
			Timestamp logintimes = rs.getTimestamp("logintimes");
			Member member = new Member(memberId, userName, password, registerTime, ifUse, logintimes);
			members.add(member);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return members;
	}

	@Override
	public Member getMemberById(int memberId) throws SQLException {
		String sql = "select * from member where memberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, memberId);
		rs = pstmt.executeQuery();
		Member member = null;
		while(rs.next()) {
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			Timestamp registerTime = rs.getTimestamp("registerTime");
			int ifUse = rs.getInt("ifUse");
			Timestamp logintimes = rs.getTimestamp("logintimes");
			member = new Member(memberId, userName, password, registerTime, ifUse, logintimes);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return member;
	}

	@Override
	public Member getMemberByName(String userName) throws SQLException {
		String sql = "select * from member where username=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, userName);
		rs = pstmt.executeQuery();
		Member member = null;
		while(rs.next()) {
			int memberId = rs.getInt("memberId");
			String password = rs.getString("password");
			Timestamp registerTime = rs.getTimestamp("registerTime");
			int ifUse = rs.getInt("ifUse");
			Timestamp logintimes = rs.getTimestamp("logintimes");
			member = new Member(memberId, userName, password, registerTime, ifUse, logintimes);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return member;
	}

}
