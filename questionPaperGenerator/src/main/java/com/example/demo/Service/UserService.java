package com.example.demo.Service;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;

public interface UserService {
	
	public ProcedureOutputResponceBean userAddOrUpdate(UserAddOrUpdateBean useraddorupdatebean);
	
	public ProcedureOutputResponceBean userDelete(Integer userid);

	public ProcedureOutputResponceBean getUserByID(Integer userid);
	
	public ProcedureOutputResponceBean getUserByRollID(String userrollid);
	
	public ProcedureOutputResponceBean getUserlist();

	public ProcedureOutputResponceBean getUserlogin(UserLoginBean userloginbean);
}
