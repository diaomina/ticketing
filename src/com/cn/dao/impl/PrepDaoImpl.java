package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cn.dao.PrepDao;
import com.cn.domain.Prep;
import com.cn.util.JDBCUtil;

/**
 * 
 * @ClassName: PrepDaoImpl 
 * @Description: PrepDao的实现类
 * @author: ljy
 * @date: 2019年9月14日 下午10:46:03
 */
public class PrepDaoImpl implements PrepDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public int add(Prep prep) throws SQLException {
		String sql = "insert into prep (trainid,pmemberid,startstation,endstation,trainnumber,starttime,endtime,price,way,booktime) values (?,?,?,?,?,?,?,?,?,?)";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, prep.getTrainId());
		pstmt.setObject(2, prep.getPmemberId());
		pstmt.setObject(3, prep.getStartStation());
		pstmt.setObject(4, prep.getEndStation());
		pstmt.setObject(5, prep.getTrainNumber());
		pstmt.setObject(6, prep.getStartTime());
		pstmt.setObject(7, prep.getEndTime());
		pstmt.setObject(8, prep.getPrice());
		pstmt.setObject(9, prep.isWay());
		pstmt.setObject(10, prep.getBooktime());
		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	@Override
	public int delete(Integer prepId) throws SQLException {
		String sql = "delete from prep where prepid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, prepId);
		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	@Override
	public int update(Prep prep) throws SQLException {
		String sql = "update prep set trainid=?,pmemberid=?,startstation=?,endstation=?,trainnumber=?,starttime=?,endtime=?,price=?,way=? where prepid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, prep.getTrainId());
		pstmt.setObject(2, prep.getPmemberId());
		pstmt.setObject(3, prep.getStartStation());
		pstmt.setObject(4, prep.getEndStation());
		pstmt.setObject(5, prep.getTrainNumber());
		pstmt.setObject(6, prep.getStartTime());
		pstmt.setObject(7, prep.getEndTime());
		pstmt.setObject(8, prep.getPrice());
		pstmt.setObject(9, prep.isWay());
		pstmt.setObject(10, prep.getPrepId());
		int recordNumber = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return recordNumber;
	}

	@Override
	public List<Prep> getAll() throws SQLException {
		String sql = "select * from prep";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Prep> list = new ArrayList<Prep>();
		while (rs.next()) {
			int prepId = rs.getInt("prepId");
			int trainId = rs.getInt("trainId");
			int pmemberId = rs.getInt("pmemberId");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String trainNumber = rs.getString("trainNumber");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			boolean way = rs.getBoolean("way");
			Timestamp booktime = rs.getTimestamp("booktime");
			Prep prep = new Prep(prepId, trainId, pmemberId, startStation, endStation, trainNumber, startTime, endTime, price, way, booktime);
			list.add(prep);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public List<Prep> getPrepByPmemberId(Integer pmemberId) throws SQLException {
		String sql = "select * from prep where pmemberid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, pmemberId);
		rs = pstmt.executeQuery();
		List<Prep> list = new ArrayList<Prep>();
		while (rs.next()) {
			int prepId = rs.getInt("prepId");
			int trainId = rs.getInt("trainId");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String trainNumber = rs.getString("trainNumber");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			boolean way = rs.getBoolean("way");
			Timestamp booktime = rs.getTimestamp("booktime");
			Prep prep = new Prep(prepId, trainId, pmemberId, startStation, endStation, trainNumber, startTime, endTime, price, way, booktime);
			list.add(prep);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public Prep getById(Integer prepId) throws SQLException {
		String sql = "select * from prep where prepid=?";
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, prepId);
		rs = pstmt.executeQuery();
		Prep prep = null;
		while(rs.next()) {
			int trainId = rs.getInt("trainId");
			int pmemberId = rs.getInt("pmemberId");
			String startStation = rs.getString("startStation");
			String endStation = rs.getString("endStation");
			String trainNumber = rs.getString("trainNumber");
			String startTime = rs.getString("startTime");
			String endTime = rs.getString("endTime");
			int price = rs.getInt("price");
			boolean way = rs.getBoolean("way");
			Timestamp booktime = rs.getTimestamp("booktime");
			prep = new Prep(prepId, trainId, pmemberId, startStation, endStation, trainNumber, startTime, endTime, price, way, booktime);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return prep;
	}

}
