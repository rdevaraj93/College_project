package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.QuestionDeficaltyViewEntity;
import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.Entity.QuestionMarkListViewEntity;
import com.example.demo.Entity.SubjectViewList;
import com.example.demo.Entity.UnitListViewEntity;

@Repository
public interface QuestionRepository extends  CrudRepository<QuestionListViewEntiry, Integer>{

	@Query("SELECT a FROM QuestionListViewEntiry a order by questionid asc")
	List<QuestionListViewEntiry> getAllQuestionlist();
	
	@Query("SELECT a FROM QuestionListViewEntiry a where departmentID in (:departmentid) order by questionid asc")
	List<QuestionListViewEntiry> getAllQuestionListBydeparmnt(Integer departmentid);
	
	@Query("SELECT questionlist FROM QuestionListViewEntiry questionlist where questionid in (:questionid) order by questionid asc")
	QuestionListViewEntiry getQuestionById(Integer questionid);
	
	@Query("SELECT questionlist FROM QuestionListViewEntiry questionlist where departmentID in (:departmentid) AND subjectid in (:subjectid) "
			+ "AND unitid in (:unitid) and difficultyid in (:difficultyid)"	+ " AND questionweightid in (:questionweightid )"
			+" AND isvalid = 'Y'order by questionid asc")
	List<QuestionListViewEntiry> getQuestionListbyExam(Integer departmentid, Integer subjectid,  List<Integer> unitid, Integer difficultyid, Integer questionweightid);

	@Query("SELECT difficultyidpk FROM QuestionDeficaltyViewEntity difficultyidpk order by difficultyidpk asc")
	List<QuestionDeficaltyViewEntity> getQuestionDeficalty();
	
	@Query("SELECT questionmarkid FROM QuestionMarkListViewEntity questionmarkid order by questionmarkid asc")
	List<QuestionMarkListViewEntity> getQuestionMarkList();
	
	@Query("SELECT a FROM UnitListViewEntity a order by unitidpk asc")
	List<UnitListViewEntity> getUnitList();
	
	@Query("SELECT a FROM SubjectViewList a order by subjectidpk asc")
	List<SubjectViewList> getSubjectNameList();
	
}
