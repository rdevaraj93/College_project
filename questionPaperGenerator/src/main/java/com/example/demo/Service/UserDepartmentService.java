package com.example.demo.Service;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;
import com.example.demo.dto.UserDepartAddOrUpdateBean;

public interface UserDepartmentService {
	
	public ProcedureOutputResponceBean userDepartAddOrUpdate(UserDepartAddOrUpdateBean userdepartaddorupdatebean);
	
	public ProcedureOutputResponceBean userDepartDelete(Integer userdepartid);
	
}
