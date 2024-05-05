package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserDepartmentService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserDepartAddOrUpdateBean;

@RestController
@RequestMapping("/userdepart/")
@CrossOrigin("http://localhost:3000/")
public class UserDepartmentController {

	@Autowired
	UserDepartmentService userdepartmentservice;
	
	@PostMapping("/adduserdepart")
	public ProcedureOutputResponceBean userDepartAddOrUpdate(@RequestBody UserDepartAddOrUpdateBean userdepartaddorupdatebean) {
		//System.out.println("*************************");
		return userdepartmentservice.userDepartAddOrUpdate(userdepartaddorupdatebean);
		
	}

	@DeleteMapping("/deleteuserdepart/{userdepartid}")
	public ProcedureOutputResponceBean userDepartDelete(@PathVariable Integer userdepartid) {
		//System.out.println("*************************");
		return userdepartmentservice.userDepartDelete(userdepartid);
		
	}
	
}
