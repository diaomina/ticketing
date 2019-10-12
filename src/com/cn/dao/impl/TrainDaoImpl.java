package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cn.dao.TrainDao;
import com.cn.domain.Train;
import com.cn.util.JDBCUtil;

/**
 * 
 * @ClassName: TrainDaoImpl 
 * @Description: TrainDao的实现类
 * @author: ljy
 * @date: 2019年9月14日 下午10:46:23
 */
public class TrainDaoImpl implements TrainDao {
	
	private Connection conn = null;
	private QueryRunner queryRunner = null;

	@Override
	public int add(Train train) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "insert into train (trainnumber,startstation,endstation,starttime,endtime,price,seatnumber,addtime) values (?,?,?,?,?,?,?,?)",
				train.getTrainNumber(),train.getStartStation(),train.getEndStation(),train.getStartTime(),train.getEndTime(),train.getPrice(),train.getSeatNumber(),train.getAddTime());
		DbUtils.close(conn);
		return recordNumber;
	}

	@Override
	public int delete(Integer trainId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "delete from train where trainid=?", trainId);
		DbUtils.close(conn);
		return recordNumber;
	}

	/*
	@Override
	public int update(Train train) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "update train set trainnumber=?,startstation=?,endstation=?,starttime=?,endtime=?,price=?,seatnumber=?,addtime=? where trainid=?", 
				train.getTrainNumber(),train.getStartStation(),train.getEndStation(),train.getStartTime(),train.getEndTime(),train.getPrice(),train.getSeatNumber(),train.getAddTime(),train.getTrainId());
		DbUtils.close(conn);
		return recordNumber;
	}*/
	
	@Override
	public int update(Train train) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "update train set trainnumber=?,startstation=?,endstation=?,starttime=?,endtime=?,price=?,seatnumber=? where trainid=?", 
				train.getTrainNumber(),train.getStartStation(),train.getEndStation(),train.getStartTime(),train.getEndTime(),train.getPrice(),train.getSeatNumber(),train.getTrainId());
		DbUtils.close(conn);
		return recordNumber;
	}
	
	

	@Override
	public List<Train> getAll() throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Train> list = queryRunner.query(conn, "select * from train", new BeanListHandler<Train>(Train.class));
		DbUtils.close(conn);
		return list;
	}

	@Override
	public Train getById(Integer trainId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		Train train = queryRunner.query(conn, "select * from train where trainid=?", new BeanHandler<Train>(Train.class), trainId);
		DbUtils.close(conn);
		return train;
	}

	@Override
	public List<Train> getByTrainNumber(String trainNumber) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Train> list = queryRunner.query(conn, "select * from train where trainnumber=?", new BeanListHandler<Train>(Train.class), trainNumber);
		DbUtils.close(conn);
		return list;
	}

	@Override
	public List<Train> getByStartEndStation(String startStation, String endStation, String startTime)
			throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Train> list = queryRunner.query(conn, "select * from train where startStation=? and endStation=? and startTime like \"%\"?\"%\"", new BeanListHandler<Train>(Train.class), startStation, endStation, startTime);
		DbUtils.close(conn);
		return list;
	}

	@Override
	public List<Train> getAllStartStation() throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Train> list= queryRunner.query(conn, "select distinct startstation from train", new BeanListHandler<Train>(Train.class));
		DbUtils.close(conn);
		return list;
	}

	@Override
	public List<Train> getAllEndStation() throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Train> list= queryRunner.query(conn, "select distinct endstation from train", new BeanListHandler<Train>(Train.class));
		DbUtils.close(conn);
		return list;
	}
	
}
