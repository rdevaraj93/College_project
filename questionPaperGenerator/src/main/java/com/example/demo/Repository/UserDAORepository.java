package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserAddOrUpdateBean;

@Repository
public class UserDAORepository extends DataBaseAdapter{

	public ProcedureOutputResponceBean userAddOrUpdate(UserAddOrUpdateBean useraddorupdatebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		System.out.println("User Add is working fine ------------------>");
		String pkguseraddorupdate =  "{call pkg_create_update_user(?,?,?,?,?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, useraddorupdatebean.getVv_user_id()); 
			callablestatement.setString(2, useraddorupdatebean.getVv_user_roll_id());
			callablestatement.setString(3, useraddorupdatebean.getVv_first_name());
			callablestatement.setString(4, useraddorupdatebean.getVv_last_name());
			callablestatement.setString(5, useraddorupdatebean.getVv_password());
			callablestatement.registerOutParameter(6, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(7, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(8, java.sql.Types.VARCHAR);
			
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(6));
			outputbean.setPo_success_flag(callablestatement.getInt(7));
			outputbean.setPo_message(callablestatement.getString(8));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}
	
public ProcedureOutputResponceBean userDelete(Integer userid) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		String pkguseraddorupdate =  "{call pkg_delete_user(?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, userid); 
			callablestatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(2));
			outputbean.setPo_success_flag(callablestatement.getInt(3));
			outputbean.setPo_message(callablestatement.getString(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}

}