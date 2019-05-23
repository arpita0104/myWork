package com.guestbook.app.entity;

import javax.persistence.*;

@Entity 
@Table(name="login_info") 
public class LoginInfo {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public LoginInfo() {
		super();
	}

	public LoginInfo(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
}
