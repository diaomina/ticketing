package com.cn.domain;

import java.sql.Timestamp;

/**
 * 
 * @ClassName: ShowPrep 
 * @Description: 用于展示订单信息的实体类，暂未使用
 * @author: ljy
 * @date: 2019年9月20日 下午4:41:18
 */
public class ShowPrep {
	private Integer ShowPrepId;	//序号
	private Integer trainId;	//车次id
	private Integer pmemberId;	//会员信息ID
	private String realName;	//乘车人姓名
	private String idCard;		//乘车人身份证号
	private String startStation;//起始站
	private String endStation;	//终点站
	private String trainNumber;	//火车车次
	private String startTime;	//开车时间
	private String endTime;		//到站时间
	private Integer price;		//车票价格
	private boolean way;		//付款情况
	private Timestamp booktime;	//订票时间
}
