package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;


@Repository
public class QuestionPaperGeneraterDAORepository  extends DataBaseAdapter{
	
	public ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean , List<Integer> finalQuestionIDList ) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();	 
		String pkguseraddorupdate =  "{call pkg_create_update_ques_paper(?,?,?,?,?,?,?,?,?,?)}";
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			
			Integer loop_count = 0;
			for (Integer questionEntity : finalQuestionIDList) {
			 
				if (loop_count == 0) {
					callablestatement.setInt(1, questionpaperaddordeletebean.getNewQuestionpaperID()); 
				}else
				{
					callablestatement.setInt(1, callablestatement.getInt(8)); 
				}
				
				callablestatement.setString(2, questionpaperaddordeletebean.getExamName());
				callablestatement.setInt(3, questionpaperaddordeletebean.getDepartmentID()); 
				callablestatement.setInt(4, questionpaperaddordeletebean.getSubjectID()); 
				callablestatement.setInt(5, questionpaperaddordeletebean.getTotalexammark()); 
				callablestatement.setString(6, questionpaperaddordeletebean.getIssuppotoptional());	
				callablestatement.setInt(7,questionEntity.intValue()  );
				callablestatement.registerOutParameter(8, java.sql.Types.INTEGER);
				callablestatement.registerOutParameter(9, java.sql.Types.INTEGER);
				callablestatement.registerOutParameter(10, java.sql.Types.VARCHAR);
				
				callablestatement.executeUpdate();
				outputbean.setPo_new_id(callablestatement.getInt(8));
				outputbean.setPo_success_flag(callablestatement.getInt(9));
				outputbean.setPo_message(callablestatement.getString(10));
				loop_count = loop_count+1;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}

	public ProcedureOutputResponceBean deleteQuestionPaper(Integer examid) {
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();	 
		String pkguseraddorupdate =  "{call pkg_delete_question_paper(?,?,?,?)}";
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			
			 
				callablestatement.setInt(1, examid);
				callablestatement.registerOutParameter(2, java.sql.Types.INTEGER);
				callablestatement.registerOutParameter(3, java.sql.Types.INTEGER);
				callablestatement.registerOutParameter(4, java.sql.Types.VARCHAR);
				
				callablestatement.executeUpdate();
				outputbean.setPo_new_id(callablestatement.getInt(2));
				outputbean.setPo_success_flag(callablestatement.getInt(3));
				outputbean.setPo_message(callablestatement.getString(4));
			 
				
			}
			 catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
		
	}
	
	
	
}
