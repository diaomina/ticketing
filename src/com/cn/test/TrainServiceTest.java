package com.cn.test;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cn.domain.Train;
import com.cn.service.TrainService;
import com.cn.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: TrainServiceTest 
 * @Description: TrainService的测试类
 * @author: ljy
 * @date: 2019年9月16日 下午10:53:36
 */
public class TrainServiceTest {
	private TrainService trainService = new TrainServiceImpl();

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
			recordNumber = trainService.add(train);
			System.out.println(recordNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBatchAdd() {
		for(int i=1; i<=300; i++) {
			Train train = new Train();
			train.setTrainNumber("K3"+i);
			train.setStartStation("北京"+i);
			train.setEndStation("天津"+i);
			train.setStartTime("2020-01-01 15:30:00");
			train.setEndTime("2020-01-02 16:50:00");
			train.setPrice(200+i);
			train.setSeatNumber(1000+i);
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Timestamp addTime = Timestamp.valueOf(sdf.format(new Date()));
			Timestamp addTime = new Timestamp(new Date().getTime());
			train.setAddTime(addTime);
			int recordNumber = 0;
			try {
				recordNumber = trainService.add(train);
				System.out.println(recordNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testDelete() {
		try {
			int recordNumber = trainService.delete(5);
			System.out.println(recordNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Train train = new Train();
		train.setTrainId(18);
		train.setTrainNumber("XXX11");
		train.setStartStation("北京");
		train.setEndStation("天津");
		train.setStartTime("2019-09-01 15:30:00");
		train.setEndTime("2019-09-01 16:50:00");
		train.setPrice(200);
		train.setSeatNumber(1000);
		//Timestamp addTime = new Timestamp(new Date().getTime());
		//train.setAddTime(addTime);
		try {
			int recordNumber = trainService.update(train);
			System.out.println(recordNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAll() {
		try {
			List<Train> list = trainService.getAll();
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		try {
			Integer trainId = 2;
			Train train = trainService.getById(trainId);
			System.out.println(train.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetByTrainNumber() {
		try {
			String trainNumber="XXX11";
			List<Train> list = trainService.getByTrainNumber(trainNumber);
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetByStartEndStation() {
		try {
			List<Train> list = trainService.getByStartEndStation("上海", "广州", "2019-09-01");
			for(Train train : list) {
				System.out.println(train.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllStartStation() {
		try {
			List<Train> list = trainService.getAllStartStation();
			for(Train train : list) {
				System.out.println(train.getStartStation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllEndStation() {
		try {
			List<Train> list = trainService.getAllEndStation();
			for(Train train : list) {
				System.out.println(train.getEndStation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
