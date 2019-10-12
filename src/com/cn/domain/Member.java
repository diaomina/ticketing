package com.cn.domain;

import java.sql.Timestamp;

public class Member {
	private Integer memberId;
	private String userName;
	private String password;
	private Timestamp registerTime;
	private Integer ifUse;
	private Timestamp logintimes;

	public Member(Integer memberId, String userName, String password, Timestamp registerTime, Integer ifUse,
			Timestamp logintimes) {
		this.memberId = memberId;
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.ifUse = ifUse;
		this.logintimes = logintimes;
	}

	public Member(String userName, String password, Timestamp registerTime, Integer ifUse, Timestamp logintimes) {
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.ifUse = ifUse;
		this.logintimes = logintimes;
	}

	public Member() {
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getIfUse() {
		return ifUse;
	}

	public void setIfUse(Integer ifUse) {
		this.ifUse = ifUse;
	}

	public Timestamp getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(Timestamp logintimes) {
		this.logintimes = logintimes;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", userName=" + userName + ", password=" + password + ", registerTime="
				+ registerTime + ", ifUse=" + ifUse + ", logintimes=" + logintimes + "]";
	}
}
