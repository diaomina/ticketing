package com.cn.dao;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Prep;

/**
 * 
 * @ClassName: PrepDao 
 * @Description: 订单表(prep)的持久层接口
 * @author: ljy
 * @date: 2019年9月13日 下午10:05:20
 */
public interface PrepDao {
	
	/**
	 * 添加订单
	 * @return 返回1为添加成功
	 * @throws SQLException
	 */
	int add(Prep prep) throws SQLException;
	
	/**
	 * 删除订单
	 * @return 返回1为删除成功
	 * @throws SQLException
	 */
	int delete(Integer prepId) throws SQLException;
	
	/**
	 * 修改订单
	 * @return 返回1为修改成功
	 * @throws SQLException
	 */
	int update(Prep prep) throws SQLException;
	
	/**
	 * 获取所有订单信息
	 * @return 返回元素为Prep对象的list
	 * @throws SQLException
	 */
	List<Prep> getAll() throws SQLException;
	
	/**
	 * 根据会员信息ID查询这个会员的所有订单
	 * @param pmemberId 会员信息ID
	 * @return
	 * @throws SQLException
	 */
	List<Prep> getPrepByPmemberId(Integer pmemberId) throws SQLException;
	
	/**
	 * 根据id查询订单信息
	 * @return Prep的对象
	 * @throws SQLException
	 */
	Prep getById(Integer prepId) throws SQLException;
	

}
