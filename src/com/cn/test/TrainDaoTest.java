package com.cn.test;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cn.dao.TrainDao;
import com.cn.dao.impl.TrainDaoImpl;
import com.cn.domain.Train;

/**
 * 
 * @ClassName: TrainDaoTest 
 * @Description: TrainDao的测试类
 * @author: ljy
 * @date: 2019年9月16日 下午10:53:22
 */
public class TrainDaoTest {
	
	private TrainDao trainDao = new TrainDaoImpl();

	@Test
	public void testAdd() {
		Train train = new Train();
		train.setTrainNumber("K322");
		train.setStartStation("北京");
		train.setEndStation("天津");
		train.setStartTime("2019-09-01 15:30:00");
		train.setEndTime("2019-09-01 16:50:00");
		train.setPrice(200);
		train.setSeatNumber(1000);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Timestamp addTime = Timestamp.valueOf(sdf.format(new Date()));
		Timestamp addTime = new Timestamp(new Date().getTime());
		train.setAddTime(addTime);
		int recordNumber = 0;
		try {
			recordNumber = trainDao.add(train);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			int recordNumber = trainDao.delete(1);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Train train = new Train();
		train.setTrainId(2);
		train.setTrainNumber("XXX");
		train.setStartStation("北京");
		train.setEndStation("天津");
		train.setStartTime("2019-09-01 15:30:00");
		train.setEndTime("2019-09-01 16:50:00");
		train.setPrice(200);
		train.setSeatNumber(1000);
		Timestamp addTime = new Timestamp(new Date().getTime());
		train.setAddTime(addTime);
		try {
			int recordNumber = trainDao.update(train);
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAll() {
		try {
			List<Train> list = trainDao.getAll();
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		try {
			Integer trainId = 2;
			Train train = trainDao.getById(trainId);
			System.out.println(train.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetByTrainNumber() {
		try {
			String trainNumber="XXX";
			List<Train> list = trainDao.getByTrainNumber(trainNumber);
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetByStartEndStation() {
		try {
			List<Train> list = trainDao.getByStartEndStation("上海", "广州", "2019-09-01");
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllStartStation() {
		try {
			List<Train> list = trainDao.getAllStartStation();
			for(Train train : list) {
				System.out.println(train.getStartStation());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllEndStation() {
		try {
			List<Train> list = trainDao.getAllEndStation();
			for(Train train : list) {
				System.out.println(train.getEndStation());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
