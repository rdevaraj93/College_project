package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserDepartmentDAORepository;
import com.example.demo.Service.UserDepartmentService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserDepartAddOrUpdateBean;
@Service
public class UserDepartmentServiceImpl implements UserDepartmentService {

	@Autowired
	UserDepartmentDAORepository userdepartmentdaorepository;
	
	@Override
	public ProcedureOutputResponceBean userDepartAddOrUpdate(UserDepartAddOrUpdateBean userdepartaddorupdatebean) {
		 return userdepartmentdaorepository.userDepartAddOrUpdate(userdepartaddorupdatebean);
	}

	@Override
	public ProcedureOutputResponceBean userDepartDelete(Integer userdepartid) {
		return userdepartmentdaorepository.userDepartDelete(userdepartid);
	}

	


}
