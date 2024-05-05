package com.example.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDepartAddOrUpdateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userdepartID;
	private Integer userID;
	private Integer departID;
	private Integer subjectID;
	
	public UserDepartAddOrUpdateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDepartAddOrUpdateBean(Integer userdepartID, Integer userID, Integer departID, Integer subjectID) {
		super();
		this.userdepartID = userdepartID;
		this.userID = userID;
		this.departID = departID;
		this.departID = subjectID;
	}
	public Integer getUserdepartID() {
		return userdepartID;
	}
	public void setUserdepartID(Integer userdepartID) {
		this.userdepartID = userdepartID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getDepartID() {
		return departID;
	}
	public void setDepartID(Integer departID) {
		this.departID = departID;
	}
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	
}
