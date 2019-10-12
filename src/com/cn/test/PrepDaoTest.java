package com.cn.test;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cn.dao.PrepDao;
import com.cn.dao.impl.PrepDaoImpl;
import com.cn.domain.Prep;

/**
 * 
 * @ClassName: PrepDaoTest 
 * @Description: PrepDao的测试类
 * @author: ljy
 * @date: 2019年9月16日 下午10:52:47
 */
public class PrepDaoTest {
	
	PrepDao prepDao = new PrepDaoImpl();

	@Test
	public void testAdd() {
		Prep prep = new Prep();
		prep.setTrainId(4);
		prep.setPmemberId(2);
		prep.setStartStation("上海");
		prep.setEndStation("北京");
		prep.setTrainNumber("K113");
		prep.setStartTime("2019-09-01 15:30:00");
		prep.setEndTime("2019-09-01 16:40:00");
		prep.setPrice(200);
		prep.setWay(false);
		Timestamp booktime = new Timestamp(new Date().getTime());
		prep.setBooktime(booktime);
		
		try {
			int recordNumber = prepDao.add(prep);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			int recordNumber = prepDao.delete(2);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Prep prep = new Prep();
		prep.setPrepId(3);
		prep.setTrainId(4);
		prep.setPmemberId(2);
		prep.setStartStation("上海");
		prep.setEndStation("北京洞窟");
		prep.setTrainNumber("K113");
		prep.setStartTime("2019-19-01 15:30:00");
		prep.setEndTime("2019-19-01 16:40:00");
		prep.setPrice(1200);
		prep.setWay(true);
		
		try {
			int recordNumber = prepDao.update(prep);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAll() {
		try {
			List<Prep> list = prepDao.getAll();
			for(Prep prep : list) {
				System.out.println(prep.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPrepByPmemberId() {
		try {
			List<Prep> list = prepDao.getPrepByPmemberId(2);
			for(Prep prep : list) {
				System.out.println(prep.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		try {
			Integer prepId = 3;
			Prep prep = prepDao.getById(prepId);
			System.out.println(prep.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * private static JDBCUtil jdbcUtil = new JDBCUtil();
	 * 
	 * @Test public void test(){
	 * 
	 * Connection conn = jdbcUtil.getConnection(); QueryRunner queryRunner = new
	 * QueryRunner();
	 * 
	 * Prep prep = new Prep(); prep.setTrainId(4); prep.setPmemberId(2);
	 * prep.setStartStation("上海"); prep.setEndStation("北京");
	 * prep.setTrainNumber("K113"); prep.setStartTime("2019-09-01 15:30:00");
	 * prep.setEndTime("2019-09-01 16:40:00"); prep.setPrice(200);
	 * prep.setWay(false); Timestamp booktime = new Timestamp(new Date().getTime());
	 * prep.setBooktime(booktime);
	 * 
	 * 
	 * try { int recordNumber = queryRunner.update(conn,
	 * "insert into prep (trainid,pmemberid,startstation,endstation,trainnumber,starttime,endtime,price,way,booktime) values (?,?,?,?,?,?,?,?,?,?)"
	 * , prep.getTrainId(),prep.getPmemberId(),prep.getStartStation(),prep.
	 * getEndStation(),prep.getTrainNumber(),prep.getStartTime(),prep.getEndTime(),
	 * prep.getPrice(),prep.isWay(),prep.getBooktime());
	 * System.out.println(recordNumber); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try { DbUtils.close(conn);
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}
