package com.cn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cn.dao.PrepDao;
import com.cn.domain.Prep;
import com.cn.domain.Train;
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
	private QueryRunner queryRunner = null;

	@Override
	public int add(Prep prep) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "insert into prep (trainid,pmemberid,startstation,endstation,trainnumber,starttime,endtime,price,way,booktime) values (?,?,?,?,?,?,?,?,?,?)",
				prep.getTrainId(),prep.getPmemberId(),prep.getStartStation(),prep.getEndStation(),prep.getTrainNumber(),prep.getStartTime(),prep.getEndTime(),prep.getPrice(),prep.isWay(),prep.getBooktime());
		DbUtils.close(conn);
		return recordNumber;
	}

	@Override
	public int delete(Integer prepId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "delete from prep where prepid=?", prepId);
		DbUtils.close(conn);
		return recordNumber;
	}

	@Override
	public int update(Prep prep) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		int recordNumber = queryRunner.update(conn, "update prep set trainid=?,pmemberid=?,startstation=?,endstation=?,trainnumber=?,starttime=?,endtime=?,price=?,way=? where prepid=?", 
				prep.getTrainId(),prep.getPmemberId(),prep.getStartStation(),prep.getEndStation(),prep.getTrainNumber(),prep.getStartTime(),prep.getEndTime(),prep.getPrice(),prep.isWay(),prep.getPrepId());
		DbUtils.close(conn);
		return recordNumber;
	}

	@Override
	public List<Prep> getAll() throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Prep> list = queryRunner.query(conn, "select * from prep", new BeanListHandler<Prep>(Prep.class));
		DbUtils.close(conn);
		return list;
	}

	@Override
	public List<Prep> getPrepByPmemberId(Integer pmemberId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		List<Prep> list = queryRunner.query(conn, "select * from prep where pmemberid=?", new BeanListHandler<Prep>(Prep.class), pmemberId);
		DbUtils.close(conn);
		return list;
	}

	@Override
	public Prep getById(Integer prepId) throws SQLException {
		conn = JDBCUtil.getConnection();
		queryRunner = new QueryRunner();
		Prep prep = queryRunner.query(conn, "select * from prep where prepid=?", new BeanHandler<Prep>(Prep.class), prepId);
		DbUtils.close(conn);
		return prep;
	}

}
