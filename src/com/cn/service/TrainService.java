package com.cn.service;

import java.sql.SQLException;
import java.util.List;

import com.cn.domain.Train;

public interface TrainService {
	/**
	 * 添加车次
	 * @return 返回1为添加成功
	 * @throws SQLException
	 */
	int add(Train train);
	
	/**
	 * 删除车次
	 * @return 返回1为删除成功
	 * @throws SQLException
	 */
	int delete(Integer trainId);
	
	/**
	 * 修改车次
	 * @return 返回1为修改成功
	 * @throws SQLException
	 */
	int update(Train train);
	
	/**
	 * 获取所有车次信息
	 * @return 返回元素为Train对象的list
	 * @throws SQLException
	 */
	List<Train> getAll();
	
	/**
	 * 根据id查询车次信息
	 * @return Train的对象
	 * @throws SQLException
	 */
	Train getById(Integer trainId);
	
	/**
	 * 根据车次查询车次信息
	 * @return 元素为Train的对象的list
	 * @throws SQLException
	 */
	List<Train> getByTrainNumber(String trainNumber);
	
	/**
	 * 根据起始站、终点站、开车时间、查询车次信息
	 * @param startStation 起始站
	 * @param endStation 终点站
	 * @param startTime 传进去的时候没有时分秒
	 * @return 元素为Train对象的list
	 * @throws SQLException
	 */
	List<Train> getByStartEndStation(String startStation, String endStation, String startTime);
	
	/**
	 * 获取所有非重复的起始站
	 * @return
	 * @throws SQLException
	 */
	List<Train> getAllStartStation();
	
	/**
	 * 获取所有非重复的终点站
	 * @return
	 * @throws SQLException
	 */
	List<Train> getAllEndStation();
}
