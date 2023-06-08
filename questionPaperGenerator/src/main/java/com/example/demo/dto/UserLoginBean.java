package com.example.demo.dto;

import lombok.Data;

@Data
public class UserLoginBean {

	private String username;
	private String password;
	
	public UserLoginBean( ) {
		 
	}

	public UserLoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
