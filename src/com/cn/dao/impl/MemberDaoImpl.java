package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
	private QueryRunner queryRunner = null;

	@Override
	public int add(Member member) throws SQLException {
		int status = 0;
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "insert into member(username,password,registertime,ifuse,logintimes) values(?,?,?,?,?)";
		status = queryRunner.update(conn, sql, member.getUserName(), member.getPassword(), member.getRegisterTime(),
				member.getIfUse(), member.getLogintimes());
		DbUtils.close(conn);
		return status;
	}

	@Override
	public int delete(int memberId) throws SQLException {
		int status = 0;
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "delete from member where memberid=?";
		status = queryRunner.update(conn, sql, memberId);
		DbUtils.close(conn);
		return status;
	}

	/*
	@Override
	public int update(Member member) throws SQLException {
		int status = 0;
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "alter table member set username=?,password=?,ifuse=?,logintimes=? where memberid=?";
		status = queryRunner.update(conn, sql, member.getUserName(), member.getPassword(), member.getIfUse(), member.getLogintimes(), member.getMemberId());
		DbUtils.close(conn);
		return status;
	}
	*/
	
	// 2019.9.28 ljy 修改了sql语句，改为update
	@Override
	public int update(Member member) throws SQLException {
		int status = 0;
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "update member set username=?,password=?,ifuse=?,logintimes=? where memberid=?";
		status = queryRunner.update(conn, sql, member.getUserName(), member.getPassword(), member.getIfUse(), member.getLogintimes(), member.getMemberId());
		DbUtils.close(conn);
		return status;
	}

	@Override
	public List<Member> getAll() throws SQLException {
		List<Member> list = new ArrayList<Member>();
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "select * from member";
		list = queryRunner.query(conn, sql, new BeanListHandler<Member>(Member.class));
		DbUtils.close(conn);
		return list;
	}

	@Override
	public Member getMemberById(int memberId) throws SQLException {
		Member member = new Member();
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "select * from member where memberid=?";
		member = queryRunner.query(conn, sql, new BeanHandler<Member>(Member.class), memberId);
		DbUtils.close(conn);
		return member;
	}

	@Override
	public Member getMemberByName(String userName) throws SQLException {
		Member member = new Member();
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		String sql = "select * from member where username=?";
		member = queryRunner.query(conn, sql, new BeanHandler<Member>(Member.class), userName);
		DbUtils.close(conn);
		return member;
	}

}
