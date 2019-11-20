package com.briup.environment.bean;
/**
 * Simple to Introduction
 * @ProjectName:  智能家居之环境监控系统
 * @Package: com.briup.environment.bean
 * @ClassName:  User
 * @Description:  管理员用户实体类,包括id,姓名,密码,性别,个人介绍
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public class User {
	//用户id
	private Integer id;
	//用户姓名
	private String username;
	//登录密码
	private String pwd;
	//性别
	private String gender;
	//个人描述信息
	private String info;
	public User() {}
	public User(Integer id, String username, String pwd, String gender,
			String info) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.gender = gender;
		this.info = info;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", gender=" + gender + ", info=" + info + "]";
	}
}
