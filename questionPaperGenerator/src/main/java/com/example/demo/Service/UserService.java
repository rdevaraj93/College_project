package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.UserEntity;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;

public interface UserService {
	
	public ProcedureOutputResponceBean userAddOrUpdate(UserAddOrUpdateBean useraddorupdatebean);
	
	public ProcedureOutputResponceBean userDelete(Integer userid);

	public UserEntity getUserByID(Integer userid);
	
	public ProcedureOutputResponceBean getUserByRollID(String userrollid);
	
	public List<UserEntity> getUserlist();

	public ProcedureOutputResponceBean getUserlogin(UserLoginBean userloginbean);
}
