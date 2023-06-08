package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.UserDepartAddOrUpdateBean;

@Repository
public class UserDepartmentDAORepository extends DataBaseAdapter {

public ProcedureOutputResponceBean userDepartAddOrUpdate(UserDepartAddOrUpdateBean userdepartaddorupdatebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		//System.out.println("User Add is working fine ------------------>");
		String pkguseraddorupdate =  "{call pkg_create_update_user_depart(?,?,?,?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, userdepartaddorupdatebean.getUserdepartID()); 
			callablestatement.setInt(2, userdepartaddorupdatebean.getUserID());
			callablestatement.setInt(3, userdepartaddorupdatebean.getDepartID());
			callablestatement.setInt(4, userdepartaddorupdatebean.getSubjectID());
			callablestatement.registerOutParameter(5, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(6, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(7, java.sql.Types.VARCHAR);	
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(5));
			outputbean.setPo_success_flag(callablestatement.getInt(6));
			outputbean.setPo_message(callablestatement.getString(7));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}

public ProcedureOutputResponceBean userDepartDelete(Integer userdepartid) {
	
	ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
	String pkguseraddorupdate =  "{call pkg_delete_user_depart(?,?,?,?)}";
	
	try(Connection connection = getJDBConnection();
			CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
		 
		callablestatement.setInt(1, userdepartid); 
		callablestatement.registerOutParameter(2, java.sql.Types.INTEGER);
		callablestatement.registerOutParameter(3, java.sql.Types.INTEGER);
		callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
		
		callablestatement.executeUpdate();
		outputbean.setPo_new_id(callablestatement.getInt(2));
		outputbean.setPo_success_flag(callablestatement.getInt(3));
		outputbean.setPo_message(callablestatement.getString(4));
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Exception Occured" + e.getLocalizedMessage());
	}
	
	return outputbean;

}

	
}
