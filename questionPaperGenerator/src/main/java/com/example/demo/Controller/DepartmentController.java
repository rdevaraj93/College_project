package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.DepartmentViewEntiry;
import com.example.demo.Service.DepartmentService;
import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;

@RestController
@RequestMapping("/department/")
@CrossOrigin("http://localhost:3000/")
public class DepartmentController {

	@Autowired
	DepartmentService departmentservice;
	
	@PostMapping("/adddepartment")
	public ProcedureOutputResponceBean departmentAddOrUpdate(@RequestBody  DepartmentAddOrUpdateBean departmentdddorupdateBean) {
		
		return departmentservice.departmentAddOrUpdate(departmentdddorupdateBean);
		
	}
	
	@DeleteMapping("/deletedepartment/{depart_id}")
	public ProcedureOutputResponceBean departmentDelete(@PathVariable Integer depart_id) {
		//System.out.println("Inside controller-->" + depart_id);
		return departmentservice.departmentDelete(depart_id);
		
	}
	
	@GetMapping("/getalldepartment")
	public List<DepartmentViewEntiry> getAllDepartment() {
	 
		return departmentservice.getAllDepartment();
	}
	
}
