package com.cn.domain;

import java.sql.Timestamp;

/**
 * @className Admin
 * @description 管理员实体类
 * @author lxs
 * @date 2019年9月1日
 */
public class Admin {
	private Integer adminId;	//管理员id
	private String userName;	//管理员姓名
	private String password;	//管理员密码
	private Timestamp creatTime;//创建时间
	private Integer flag;		//管理员权限
	private Integer isUse;		//管理员状态
	private Timestamp loginTime;//登录时间
	public Admin(Integer adminId, String userName, String password, Timestamp creatTime, Integer flag, Integer isUse,
			Timestamp loginTime) {
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.creatTime = creatTime;
		this.flag = flag;
		this.isUse = isUse;
		this.loginTime = loginTime;
	}
	public Admin(String userName, String password, Timestamp creatTime, Integer flag, Integer isUse,
			Timestamp loginTime) {
		this.userName = userName;
		this.password = password;
		this.creatTime = creatTime;
		this.flag = flag;
		this.isUse = isUse;
		this.loginTime = loginTime;
	}
	public Admin() {
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", creatTime="
				+ creatTime + ", flag=" + flag + ", isUse=" + isUse + ", loginTime=" + loginTime + "]";
	}
}
