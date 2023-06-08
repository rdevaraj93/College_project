package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DepartmentDAORepository;
import com.example.demo.Service.DepartmentService;
import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAORepository departmentdaorepository;
	
	public ProcedureOutputResponceBean  departmentAddOrUpdate(DepartmentAddOrUpdateBean departmentdddorupdateBean) {
		 
		return departmentdaorepository.departmentAddOrUpdate(departmentdddorupdateBean);
		
	}
	
	@Override
	public ProcedureOutputResponceBean departmentDelete(Integer depart_id) {
	//	System.out.println("Inside Service imple-->" + depart_id);
		return departmentdaorepository.departmentDelete(depart_id);
	}

}
