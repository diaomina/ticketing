package com.cn.dao;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Pmember;

/**
 * 
 * @ClassName: PmemberDao 
 * @Description: pmember表的持久层接口
 * @author: ljy
 * @date: 2019年9月14日 下午5:13:28
 */
public interface PmemberDao {

	/**
	 * 添加个人信息
	 * @return 返回1为添加成功
	 * @throws SQLException
	 */
	int add(Pmember pmember) throws SQLException;
	
	/**
	 * 删除个人信息
	 * @return 返回1为删除成功
	 * @throws SQLException
	 */
	int delete(Integer pmemberId) throws SQLException;
	
	/**
	 * 修改个人信息
	 * @return 返回1为修改成功
	 * @throws SQLException
	 */
	int update(Pmember pmember) throws SQLException;
	
	
	/**
	 * 获取所有个人信息
	 * @return 返回元素为Pmember对象的list
	 * @throws SQLException
	 */
	/*
	List<Pmember> getAll() throws SQLException;
	*/
	
	/**
	 * 根据会员ID查询这个会员的个人信息
	 * @param memberId 会员ID
	 * @return Pmember对象
	 * @throws SQLException
	 */
	Pmember getPmemberByMemberId(Integer memberId) throws SQLException;
	
	/**
	 * 根据id查询会员个人信息
	 * @return Pmember的对象
	 * @throws SQLException
	 */
	Pmember getById(Integer pmemberId) throws SQLException;
	
}
