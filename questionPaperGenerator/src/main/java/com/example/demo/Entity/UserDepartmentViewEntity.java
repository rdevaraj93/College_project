package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@Entity
@Table(name = "vw_user_department")
public class UserDepartmentViewEntity {

	
	@Id
	@Column(name="user_depart_pk")
	private Integer userdepartmentID;
	
	@Column(name="user_id_fk")
	private Integer userid ;
	
	@Column(name="User_Roll_ID")
	private String userrollid;

	@Column(name="first_Name")
	private String firstname;
	
	@Column(name="Last_name")
	private String lastname;
	
	@Column(name="display_Name")
	private String displayname;
	
	@Column(name="depart_id_fk")
	private Integer departmentid;
	
	@Column(name="depart_name")
	private String departmentname;
	
	@Column(name="subject_id_fk")
	private Integer subjectid;
	
	@Column(name="subject_name")
	private String subjectname;

	public UserDepartmentViewEntity() {
		super();
	}

	public UserDepartmentViewEntity(Integer userdepartmentID, Integer userid, String userrollid, String firstname,
			String lastname, String displayname, Integer departmentid, String departmentname, Integer subjectid,
			String subjectname) {
		super();
		this.userdepartmentID = userdepartmentID;
		this.userid = userid;
		this.userrollid = userrollid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.displayname = displayname;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.subjectid = subjectid;
		this.subjectname = subjectname;
	}

	public Integer getUserdepartmentID() {
		return userdepartmentID;
	}

	public void setUserdepartmentID(Integer userdepartmentID) {
		this.userdepartmentID = userdepartmentID;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserrollid() {
		return userrollid;
	}

	public void setUserrollid(String userrollid) {
		this.userrollid = userrollid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Integer getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	
	
}
