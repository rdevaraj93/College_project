package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserDAORepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Constants;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAORepository userdaorepositer;
	
	@Autowired
	UserRepository	userrepository;
	
	@Override
	public ProcedureOutputResponceBean userAddOrUpdate(UserAddOrUpdateBean useraddorupdatebean) {
		
		return userdaorepositer.userAddOrUpdate(useraddorupdatebean);
	}

	@Override
	public ProcedureOutputResponceBean userDelete(Integer userid) {
		 
		return userdaorepositer.userDelete(userid);
		
	}

	@Override
	public ProcedureOutputResponceBean getUserByID(Integer userid) {
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<UserEntity> userDetailsList = userrepository.getUserByID(userid);
		for (UserEntity userEntity : userDetailsList) 
		{
			System.out.println("****************************");
			System.out.println("User Id "+userEntity.getUseridpk());
			System.out.println("User dispalyname "+userEntity.getUserdisplayname());
			System.out.println("User rollID "+userEntity.getUserrollid());
			System.out.println("User paswod "+userEntity.getUserpassword());
		}
		outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
		outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
		outputbean.setPo_message(Constants.SUCCESS);
		return   outputbean;
	}

	@Override
	public ProcedureOutputResponceBean getUserByRollID(String userrollid) {
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<UserEntity> userDetailsList = userrepository.getUserByRollID(userrollid);
		
		for (UserEntity userEntity : userDetailsList) 
		{
			System.out.println("****************************");
			System.out.println("User Id "+userEntity.getUseridpk());
			System.out.println("User dispalyname "+userEntity.getUserdisplayname());
			System.out.println("User rollID "+userEntity.getUserrollid());
			System.out.println("User paswod "+userEntity.getUserpassword());
		}
		outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
		outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
		outputbean.setPo_message(Constants.SUCCESS);
		return   outputbean;
		
	}
	
	@Override
	public ProcedureOutputResponceBean getUserlist() {
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<UserEntity> userDetailsList = userrepository.getUserlist();
		
		
		if (userDetailsList.size() > 0) {
			for (UserEntity userEntity : userDetailsList) 
			{
				System.out.println("****************************");
				System.out.println("User Id "+userEntity.getUseridpk());
				System.out.println("User dispalyname "+userEntity.getUserdisplayname());
				System.out.println("User rollID "+userEntity.getUserrollid());
				System.out.println("User paswod "+userEntity.getUserpassword());
				
				outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
				outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
				outputbean.setPo_message(Constants.SUCCESS);
			}
		}
		else
		{
			System.out.println("User doesn't exist");
			outputbean.setPo_new_id(Constants.FAILURE_INTERGER_VALUE);
			outputbean.setPo_success_flag(Constants.FAILURE_FLAG_VALUE);
			outputbean.setPo_message(Constants.FAILURE);
		}		
		
		return   outputbean;
		
	}

	@Override
	public ProcedureOutputResponceBean getUserlogin(UserLoginBean userloginbean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<UserEntity> userDetailsList = userrepository.getUserByRollID(userloginbean.getUsername());
		
		//System.out.println("Given User ID "+ userDetailsList.size());
		
		if (userDetailsList.size() == 1) {
			for (UserEntity userEntity : userDetailsList) 
			{
				
				if (userEntity.getUserrollid().equals(userloginbean.getUsername()) && (userEntity.getUserpassword().equals(userloginbean.getPassword())) )
				{
					outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
					outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
					outputbean.setPo_message(Constants.SUCCESS);
					System.out.println("User rollID "+userEntity.getUserrollid());
					System.out.println("User paswod "+userEntity.getUserpassword());
				}
				else
				{
					System.out.println("User doesn't exist");
					outputbean.setPo_new_id(Constants.FAILURE_INTERGER_VALUE);
					outputbean.setPo_success_flag(Constants.FAILURE_FLAG_VALUE);
					outputbean.setPo_message(Constants.FAILURE);
				}
				
			}
		}
		else
		{
			System.out.println("User doesn't exist");
			outputbean.setPo_new_id(Constants.FAILURE_INTERGER_VALUE);
			outputbean.setPo_success_flag(Constants.FAILURE_FLAG_VALUE);
			outputbean.setPo_message(Constants.FAILURE);
		}
		
		//List<UserEntity> userDetailsList = userrepository.getUserlist();
//		for (UserEntity userEntity : userDetailsList) 
//		{
//			System.out.println("****************************");
//			System.out.println("User Id "+userEntity.getUseridpk());
//			System.out.println("User dispalyname "+userEntity.getUserdisplayname());
//			System.out.println("User rollID "+userEntity.getUserrollid());
//			System.out.println("User paswod "+userEntity.getUserpassword());
//		}
		return outputbean;
	}
	
}
