package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/userlogin/")
	public ProcedureOutputResponceBean getUserlogin(@RequestBody UserLoginBean userloginbean) {
		return userservice.getUserlogin(userloginbean);
		//System.out.println("TEST");
	}
	
	@GetMapping("/getuser/userid/{userid}")
	public ProcedureOutputResponceBean getUserByID(@PathVariable Integer userid) {
		return userservice.getUserByID(userid);
		//System.out.println("TEST");
	}
	
	@GetMapping("/getuser/userrollid/{userrollid}")
	public ProcedureOutputResponceBean getUserByRollID(@PathVariable String userrollid) {
		return userservice.getUserByRollID(userrollid);
		//System.out.println("TEST");
	}
	
	@GetMapping("/getuser/userlist/")
	public ProcedureOutputResponceBean getUserlist() {
		return userservice.getUserlist();
		//System.out.println("TEST");
	}
	
	@PostMapping("/adduser")
	public ProcedureOutputResponceBean userAddOrUpdate(@RequestBody UserAddOrUpdateBean useraddorupdatebean) {
		//System.out.println(" Procedure output "+userservice.userAddOrUpdate(useraddorupdatebean).getPo_user_id());
		//System.out.println("*************************");
		return userservice.userAddOrUpdate(useraddorupdatebean);
		
	}

	@DeleteMapping("/deleteuser/{userid}")
	public ProcedureOutputResponceBean userDelete(@PathVariable Integer userid) {
		
		return userservice.userDelete(userid);
		
	}
		
	
	
}
