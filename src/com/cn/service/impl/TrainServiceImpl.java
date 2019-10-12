package com.cn.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cn.dao.TrainDao;
import com.cn.dao.impl.TrainDaoImpl;
import com.cn.domain.Train;
import com.cn.service.TrainService;

/**
 * 
 * @ClassName: TrainServiceImpl 
 * @Description: TrainService的实现类
 * @author: ljy
 * @date: 2019年9月14日 下午10:47:50
 */
public class TrainServiceImpl implements TrainService {
	
	private TrainDao trainDao = new TrainDaoImpl();
	private static Logger logger = Logger.getLogger(TrainServiceImpl.class);

	@Override
	public int add(Train train) {
		int recordNumber = 0;
		if(train!=null) {
			try {
				recordNumber = trainDao.add(train);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.add 中 train为null");
		}
		return recordNumber;
	}

	@Override
	public int delete(Integer trainId) {
		int recordNumber = 0;
		if(trainId!=null && trainId!=0) {
			try {
				recordNumber = trainDao.delete(trainId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.delete 中 trainId为null或0");
		}
		return recordNumber;
	}

	@Override
	public int update(Train train) {
		int recordNumber = 0;
		if(train!=null) {
			try {
				recordNumber = trainDao.update(train);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.update 中 train为null");
		}
		return recordNumber;
	}

	@Override
	public List<Train> getAll() {
		List<Train> list = null;
		try {
			list = trainDao.getAll();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Train getById(Integer trainId) {
		Train train = null;
		if(trainId!=null && trainId!=0) {
			try {
				train = trainDao.getById(trainId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.getById 中 trainId为null或0");
		}
		return train;
	}

	@Override
	public List<Train> getByTrainNumber(String trainNumber) {
		List<Train> list = null;
		if(trainNumber!=null && !"".equals(trainNumber)) {
			try {
				list = trainDao.getByTrainNumber(trainNumber);		
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Train> getByStartEndStation(String startStation, String endStation, String startTime) {
		List<Train> list = null;
		if(startStation!=null && !"".equals(startStation) && endStation!=null && !"".equals(endStation) 
				&& startTime!=null && !"".equals(startTime)) {
			
			try {
				list = trainDao.getByStartEndStation(startStation, endStation, startTime);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
			
		} else {
			logger.debug("TrainServiceImpl.getByStartEndStation: 信息不完整！！！");
		}
		return list;
	}

	@Override
	public List<Train> getAllStartStation() {
		List<Train> list = null;
		try {
			list = trainDao.getAllStartStation();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Train> getAllEndStation() {
		List<Train> list = null;
		try {
			list = trainDao.getAllEndStation();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

}
