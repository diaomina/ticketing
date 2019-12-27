package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public int add(Train train) throws SQLException {
		String sql = "insert into train (trainnumber,startstation,endstation,starttime,endtime,price,seatnumber,addtime) values (?,?,?,?,?,?,?,?)";

		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, train.getTrainNumber());
		pstmt.setObject(2, train.getStartStation());
		pstmt.setObject(3, train.getEndStation());
		pstmt.setObject(4, train.getStartTime());
		pstmt.setObject(5, train.getEndTime());
		pstmt.setObject(6, train.getPrice());
		pstmt.setObject(7, train.getSeatNumber());
		pstmt.setObject(8, train.getAddTime());

		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	@Override
	public int delete(Integer trainId) throws SQLException {
		String sql = "delete from train where trainid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, trainId);
		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	/*
	 * @Override public int update(Train train) throws SQLException { conn =
	 * JDBCUtil.getConnection(); queryRunner = new QueryRunner(); int recordNumber =
	 * queryRunner.update(conn,
	 * "update train set trainnumber=?,startstation=?,endstation=?,starttime=?,endtime=?,price=?,seatnumber=?,addtime=? where trainid=?"
	 * , train.getTrainNumber(),train.getStartStation(),train.getEndStation(),train.
	 * getStartTime(),train.getEndTime(),train.getPrice(),train.getSeatNumber(),
	 * train.getAddTime(),train.getTrainId()); conn.close(); return
	 * recordNumber; }
	 */

	@Override
	public int update(Train train) throws SQLException {
		String sql = "update train set trainnumber=?,startstation=?,endstation=?,starttime=?,endtime=?,price=?,seatnumber=? where trainid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, train.getTrainNumber());
		pstmt.setObject(2, train.getStartStation());
		pstmt.setObject(3, train.getEndStation());
		pstmt.setObject(4, train.getStartTime());
		pstmt.setObject(5, train.getEndTime());
		pstmt.setObject(6, train.getPrice());
		pstmt.setObject(7, train.getSeatNumber());
		pstmt.setObject(8, train.getTrainId());

		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	@Override
	public List<Train> getAll() throws SQLException {
		String sql = "select * from train";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Train> list = new ArrayList<Train>();
		while (rs.next()) {
			int trainId = rs.getInt("trainId");
			String trainNumber = rs.getString("trainNumber");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			int seatNumber = rs.getInt("seatNumber");
			Timestamp addTime = rs.getTimestamp("addTime");
			Train train = new Train(trainId, trainNumber, startStation, endStation, startTime, endTime, price,
					seatNumber, addTime);
			list.add(train);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public Train getById(Integer trainId) throws SQLException {
		String sql = "select * from train where trainid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, trainId);
		rs = pstmt.executeQuery();
		Train train = null;
		while (rs.next()) {
			String trainNumber = rs.getString("trainNumber");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			int seatNumber = rs.getInt("seatNumber");
			Timestamp addTime = rs.getTimestamp("addTime");
			train = new Train(trainId, trainNumber, startStation, endStation, startTime, endTime, price, seatNumber,
					addTime);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return train;
	}

	@Override
	public List<Train> getByTrainNumber(String trainNumber) throws SQLException {
		String sql = "select * from train where trainnumber=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, trainNumber);
		rs = pstmt.executeQuery();
		List<Train> list = new ArrayList<Train>();
		while (rs.next()) {
			int trainId = rs.getInt("trainId");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			int seatNumber = rs.getInt("seatNumber");
			Timestamp addTime = rs.getTimestamp("addTime");
			Train train = new Train(trainId, trainNumber, startStation, endStation, startTime, endTime, price,
					seatNumber, addTime);
			list.add(train);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public List<Train> getByStartEndStation(String startStation, String endStation, String startTime)
			throws SQLException {
		String sql = "select * from train where startStation=? and endStation=? and startTime like \"%\"?\"%\"";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, startStation);
		pstmt.setObject(2, endStation);
		pstmt.setObject(3, startTime);
		rs = pstmt.executeQuery();
		List<Train> list = new ArrayList<Train>();
		while (rs.next()) {
			int trainId = rs.getInt("trainId");
			String trainNumber = rs.getString("trainNumber");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			int seatNumber = rs.getInt("seatNumber");
			Timestamp addTime = rs.getTimestamp("addTime");
			Train train = new Train(trainId, trainNumber, startStation, endStation, startTime, endTime, price,
					seatNumber, addTime);
			list.add(train);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public List<Train> getAllStartStation() throws SQLException {
		String sql = "select distinct startstation from train";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Train> list = new ArrayList<Train>();
		
		while (rs.next()) {
			String startStation = rs.getString("startStation");
			Train train = new Train();
			train.setStartStation(startStation);
			list.add(train);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public List<Train> getAllEndStation() throws SQLException {
		String sql = "select distinct endstation from train";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Train> list = new ArrayList<Train>();
		while (rs.next()) {
			String endStation = rs.getString("endStation");
			Train train = new Train();
			train.setEndStation(endStation);
			list.add(train);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

}
