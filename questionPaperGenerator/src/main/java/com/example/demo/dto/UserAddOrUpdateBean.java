package com.example.demo.dto;

 
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter

public class UserAddOrUpdateBean {
	
	private Integer vv_user_id;
	private String vv_user_roll_id;
	private String vv_first_name;
	private String vv_last_name;
	private String vv_password;
	
	public UserAddOrUpdateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserAddOrUpdateBean(Integer vv_user_id, String vv_user_roll_id, String vv_first_name, String vv_last_name,
			String vv_password) {
		super();
		this.vv_user_id = vv_user_id;
		this.vv_user_roll_id = vv_user_roll_id;
		this.vv_first_name = vv_first_name;
		this.vv_last_name = vv_last_name;
		this.vv_password = vv_password;
	}

	public Integer getVv_user_id() {
		return vv_user_id;
	}
	public void setVv_user_id(Integer vv_user_id) {
		this.vv_user_id = vv_user_id;
	}
	public String getVv_user_roll_id() {
		return vv_user_roll_id;
	}
	public void setVv_user_roll_id(String vv_user_roll_id) {
		this.vv_user_roll_id = vv_user_roll_id;
	}
	public String getVv_first_name() {
		return vv_first_name;
	}
	public void setVv_first_name(String vv_first_name) {
		this.vv_first_name = vv_first_name;
	}
	public String getVv_last_name() {
		return vv_last_name;
	}
	public void setVv_last_name(String vv_last_name) {
		this.vv_last_name = vv_last_name;
	 
	}
	public String getVv_password() {
		return vv_password;
	}
	public void setVv_password(String vv_password) {
		this.vv_password = vv_password;
	}
	
}
