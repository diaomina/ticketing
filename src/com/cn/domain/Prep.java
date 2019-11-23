package com.cn.domain;

import java.sql.Timestamp;

/**
 * 
 * @ClassName: Prep 
 * @Description: 订票信息实体类
 * @author: ljy
 * @date: 2019年9月14日 下午5:12:42
 */
public class Prep {
	private Integer prepId;		//序号
	private Integer trainId;	//车次id
	private Integer pmemberId;	//会员资料ID
	private String startStation;//起始站
	private String endStation;	//终点站
	private String trainNumber;	//火车车次
	private String startTime;	//开车时间
	private String endTime;		//到站时间
	private Integer price;		//车票价格
	private boolean way;		//付款情况
	private Timestamp booktime;	//订票时间
	public Integer getPrepId() {
		return prepId;
	}
	public void setPrepId(Integer prepId) {
		this.prepId = prepId;
	}
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public Integer getPmemberId() {
		return pmemberId;
	}
	public void setPmemberId(Integer pmemberId) {
		this.pmemberId = pmemberId;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public boolean isWay() {
		return way;
	}
	public void setWay(boolean way) {
		this.way = way;
	}
	public Timestamp getBooktime() {
		return booktime;
	}
	public void setBooktime(Timestamp booktime) {
		this.booktime = booktime;
	}
	
	@Override
	public String toString() {
		return "Prep [prepId=" + prepId + ", trainId=" + trainId + ", pmemberId=" + pmemberId + ", startStation="
				+ startStation + ", endStation=" + endStation + ", trainNumber=" + trainNumber + ", startTime="
				+ startTime + ", endTime=" + endTime + ", price=" + price + ", way=" + way + ", booktime=" + booktime
				+ "]";
	}
	
	
}
