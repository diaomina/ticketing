package com.cn.domain;

import java.sql.Timestamp;

/**
 * 
 * @ClassName: Train 
 * @Description: 车次信息的实体类
 * @author: ljy
 * @date: 2019年9月1日 下午1:23:31
 */
public class Train {

	private Integer trainId;	//序号
	private String trainNumber;//车次
	private String startStation;//起始站
	private String endStation;	//终点站
	private String startTime;	//开车时间
	private String endTime;		//到站时间
	private Integer price;		//车票价格
	private Integer seatNumber;	//座位数量
	private Timestamp addTime;	//添加日期
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
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
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
	public Train(String trainNumber, String startStation, String endStation, String startTime,
			String endTime, Integer price, Integer seatNumber, Timestamp addTime) {
		this.trainNumber = trainNumber;
		this.startStation = startStation;
		this.endStation = endStation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.seatNumber = seatNumber;
		this.addTime = addTime;
	}
	
	public Train() {
	}
	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainNumber=" + trainNumber + ", startStation=" + startStation
				+ ", endStation=" + endStation + ", startTime=" + startTime + ", endTime=" + endTime + ", price="
				+ price + ", seatNumber=" + seatNumber + ", addTime=" + addTime + "]";
	}
	
	
}
