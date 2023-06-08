package com.example.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vw_user")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id_pk")
	private Integer useridpk;
	
	@Column(name="User_Roll_ID")
	private String userrollid;

	@Column(name="first_Name")
	private String userfirstname;

	@Column(name="Last_name")
	private String userlastname;

	@Column(name="display_Name")
	private String userdisplayname;

	@Column(name="password")
	private String userpassword;

	public Integer getUseridpk() {
		return useridpk;
	}

	public void setUseridpk(Integer useridpk) {
		this.useridpk = useridpk;
	}

	public String getUserrollid() {
		return userrollid;
	}

	public void setUserrollid(String userrollid) {
		this.userrollid = userrollid;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUserdisplayname() {
		return userdisplayname;
	}

	public void setUserdisplayname(String userdisplayname) {
		this.userdisplayname = userdisplayname;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
 
	
}
