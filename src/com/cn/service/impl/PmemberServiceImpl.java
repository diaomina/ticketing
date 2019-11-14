package com.cn.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cn.dao.PmemberDao;
import com.cn.dao.impl.PmemberDaoImpl;
import com.cn.domain.Pmember;
import com.cn.service.PmemberService;

/**
 * 
 * @ClassName: PmemberServiceImpl 
 * @Description: PmemberService的实现类
 * @author: ljy
 * @date: 2019年9月14日 下午11:52:30
 */
public class PmemberServiceImpl implements PmemberService {
	
	private PmemberDao pmemberDao = new PmemberDaoImpl();
	private static Logger logger = Logger.getLogger(PmemberServiceImpl.class);

	@Override
	public int add(Pmember pmember) {
		int recordNumber = 0;
		if(pmember!=null) {
			try {
				recordNumber = pmemberDao.add(pmember);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PmemberServiceImpl.add 中 pmember为null");
		}
		return recordNumber;
	}

	@Override
	public int delete(Integer pmemberId) {
		int recordNumber = 0;
		if(pmemberId!=null && pmemberId!=0) {
			try {
				recordNumber = pmemberDao.delete(pmemberId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PmemberServiceImpl.delete 中 pmemberId为null或0");
		}
		return recordNumber;
	}

	@Override
	public int update(Pmember pmember) {
		int recordNumber = 0;
		if(pmember!=null) {
			try {
				recordNumber = pmemberDao.update(pmember);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PmemberServiceImpl.update 中 pmember为null");
		}
		return recordNumber;
	}

	@Override
	public Pmember getPmemberByMemberId(Integer memberId) {
		Pmember pmember = null;
		if(memberId!=null && memberId!=0) {
			try {
				pmember = pmemberDao.getPmemberByMemberId(memberId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		} else {
			logger.debug("PmemberServiceImpl.getPmemberByMemberId 中 memberId为null或0");
		}		
		return pmember;
	}

	@Override
	public Pmember getById(Integer pmemberId) {
		Pmember pmember = null;
		if(pmemberId!=null && pmemberId!=0) {
			try {
				pmember = pmemberDao.getById(pmemberId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PmemberServiceImpl.getById 中 pmemberId为null或0");
		}
		return pmember;
	}

}
