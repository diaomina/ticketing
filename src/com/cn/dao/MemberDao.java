package com.cn.dao;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Member;

/**
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月8日
 */
public interface MemberDao {
	int add(Member member) throws SQLException;
	
	int delete(int memberId) throws SQLException;
	
	int update(Member member) throws SQLException;
	
	
	List<Member> getAll() throws SQLException;
	
	Member getMemberById(int memberId) throws SQLException;
	
	Member getMemberByName(String userName) throws SQLException;
}
