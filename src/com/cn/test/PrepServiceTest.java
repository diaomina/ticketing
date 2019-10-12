package com.cn.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cn.domain.Prep;
import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: PrepServiceTest 
 * @Description: PrepService的测试类
 * @author: ljy
 * @date: 2019年9月16日 下午10:53:03
 */
public class PrepServiceTest {
	
	private PrepService prepService = new PrepServiceImpl();

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
		
		int recordNumber = prepService.add(prep);
		System.out.println(recordNumber);

	}

	@Test
	public void testDelete() {
		int recordNumber = prepService.delete(4);
		System.out.println(recordNumber);
	}

	@Test
	public void testUpdate() {
		Prep prep = new Prep();
		prep.setPrepId(6);
		prep.setTrainId(4);
		prep.setPmemberId(2);
		prep.setStartStation("上海");
		prep.setEndStation("北京洞窟");
		prep.setTrainNumber("K113");
		prep.setStartTime("2019-19-01 15:30:00");
		prep.setEndTime("2019-19-01 16:40:00");
		prep.setPrice(1200);
		prep.setWay(true);
		
		int recordNumber = prepService.update(prep);
		System.out.println(recordNumber);
	}

	@Test
	public void testGetAll() {
		List<Prep> list = prepService.getAll();
		for(Prep prep : list) {
			System.out.println(prep.toString());
		}
	}

	@Test
	public void testGetPrepByPmemberId() {
		List<Prep> list = prepService.getPrepByPmemberId(2);
		for(Prep prep : list) {
			System.out.println(prep.toString());
		}
	}

	@Test
	public void testGetById() {
		Integer prepId = 3;
		Prep prep = prepService.getById(prepId);
		System.out.println(prep.toString());
	}

}
