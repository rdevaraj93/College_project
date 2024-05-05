package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.DepartmentViewEntiry;
import com.example.demo.Repository.DepartmentDAORepository;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Service.DepartmentService;
import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAORepository departmentdaorepository;
	
	@Autowired
	DepartmentRepository departmentrepository;
	
	public ProcedureOutputResponceBean  departmentAddOrUpdate(DepartmentAddOrUpdateBean departmentdddorupdateBean) { 
		return departmentdaorepository.departmentAddOrUpdate(departmentdddorupdateBean);	
	}
	
	@Override
	public ProcedureOutputResponceBean departmentDelete(Integer depart_id) {
	//	System.out.println("Inside Service imple-->" + depart_id);
		return departmentdaorepository.departmentDelete(depart_id);
	}

	@Override
	public List<DepartmentViewEntiry> getAllDepartment() {
		System.out.println("ddeparmetn service");
		return departmentrepository.getAllDepartment();
		 
		 
	}

}
