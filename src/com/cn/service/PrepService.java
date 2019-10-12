package com.cn.service;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Prep;

public interface PrepService {

	/**
	 * 添加订单
	 * @return 返回1为添加成功
	 */
	int add(Prep prep);
	
	/**
	 * 删除订单
	 * @return 返回1为删除成功
	 */
	int delete(Integer prepId);
	
	/**
	 * 修改订单
	 * @return 返回1为修改成功
	 */
	int update(Prep prep);
	
	/**
	 * 获取所有订单信息
	 * @return 返回元素为Prep对象的list
	 */
	List<Prep> getAll();
	
	/**
	 * 根据会员信息ID查询这个会员的所有订单
	 * @param pmemberId 会员信息ID
	 * @return
	 */
	List<Prep> getPrepByPmemberId(Integer pmemberId);
	
	/**
	 * 根据id查询订单信息
	 * @return Prep的对象
	 */
	Prep getById(Integer prepId);
	
}
