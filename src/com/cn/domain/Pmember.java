package com.cn.domain;

/**
 * 
 * @ClassName: Pmember 
 * @Description: 会员个人信息实体类
 * @author: ljy
 * @date: 2019年9月14日 下午5:13:06
 */
public class Pmember {
	
	private Integer pmemberId;	//序号
	private Integer memberId;	//会员ID
	private String realName;	//真实姓名
	private String sex;			//会员性别
	private Integer age;		//会员年龄
	private String idCard;		//身份证号
	public Integer getPmemberId() {
		return pmemberId;
	}
	public void setPmemberId(Integer pmemberId) {
		this.pmemberId = pmemberId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@Override
	public String toString() {
		return "Pmember [pmemberId=" + pmemberId + ", memberId=" + memberId + ", realName=" + realName + ", sex=" + sex
				+ ", age=" + age + ", idCard=" + idCard + "]";
	}
	
	
}
