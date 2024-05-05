package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.QuestionDeficaltyViewEntity;
import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;

@Repository
public class QuestionDAORepository extends DataBaseAdapter {

	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		System.out.println("User Add is working fine ------------------>");
		String pkguseraddorupdate =  "{call pkg_create_update_Question(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, questionaddorupdatebean.getQuestionId()); 
			callablestatement.setString(2, questionaddorupdatebean.getQuestionuniid());
			callablestatement.setString(3, questionaddorupdatebean.getQuestionDescription());
			callablestatement.setInt(4, questionaddorupdatebean.getDepartId()); 
			callablestatement.setInt(5, questionaddorupdatebean.getSubjectId()); 
			callablestatement.setInt(6, questionaddorupdatebean.getUnitId()); 
			callablestatement.setInt(7, questionaddorupdatebean.getDifficultyId()); 
			callablestatement.setInt(8, questionaddorupdatebean.getTermId()); 
			callablestatement.setInt(9, questionaddorupdatebean.getQuestWeightAgeId());
			callablestatement.setString(10, questionaddorupdatebean.getIsImportant());
			callablestatement.setString(11, questionaddorupdatebean.getIsRepeat());
			callablestatement.setString(12, questionaddorupdatebean.getIsValid());		 
			callablestatement.setInt(13, questionaddorupdatebean.getCreateUserId()); 
			callablestatement.setInt(14, questionaddorupdatebean.getUpdatedUserId()); 
			callablestatement.registerOutParameter(15, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(16, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(17, java.sql.Types.VARCHAR);	
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(15));
			outputbean.setPo_success_flag(callablestatement.getInt(16));
			outputbean.setPo_message(callablestatement.getString(17));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		System.out.println(outputbean.getPo_new_id());
		System.out.println(outputbean.getPo_success_flag());
		System.out.println(outputbean.getPo_message());
		
		return outputbean;
	
	}

	 
	
}
