package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;

@Repository
public class DepartmentDAORepository extends DataBaseAdapter{

public ProcedureOutputResponceBean departmentAddOrUpdate(DepartmentAddOrUpdateBean departmentaddorupdatebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		//System.out.println("User Add is working fine ------------------>");
		String pkguseraddorupdate =  "{call pkg_create_update_Department(?,?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, departmentaddorupdatebean.getDepartmentId()); 
			callablestatement.setString(2, departmentaddorupdatebean.getDepartmentName());
			callablestatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(4, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(5, java.sql.Types.VARCHAR);	
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(3));
			outputbean.setPo_success_flag(callablestatement.getInt(4));
			outputbean.setPo_message(callablestatement.getString(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}
	
public ProcedureOutputResponceBean departmentDelete(Integer depart_id) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		String pkgcallstament =  "{call pkg_delete_department(?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkgcallstament)){
			
			callablestatement.setInt(1,depart_id); 
			callablestatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(2));
			outputbean.setPo_success_flag(callablestatement.getInt(3));
			outputbean.setPo_message(callablestatement.getString(4));
			
			System.out.println( "--------->" + callablestatement.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured" +  e.getStackTrace());
		}
		
		return outputbean;
	
	}
	
}
