package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.DepartmentViewEntiry;
import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;

public interface DepartmentService {
	
	public ProcedureOutputResponceBean departmentAddOrUpdate(DepartmentAddOrUpdateBean departmentdddorupdateBean);
	
	public ProcedureOutputResponceBean departmentDelete(Integer depart_id) ;
	
	public List<DepartmentViewEntiry> getAllDepartment();
}
