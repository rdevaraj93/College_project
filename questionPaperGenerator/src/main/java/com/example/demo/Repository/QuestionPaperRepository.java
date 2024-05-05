package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.ExamListViewEntity;
import com.example.demo.Entity.ExamQuestionListViewEntity;

@Repository
public interface QuestionPaperRepository extends CrudRepository<ExamQuestionListViewEntity, Integer> {

	@Query("SELECT questionlist FROM ExamQuestionListViewEntity questionlist")
	List<ExamQuestionListViewEntity> getExamQuestionList();
	
	@Query("SELECT questionlist FROM ExamQuestionListViewEntity questionlist where examid in (:examid)")
	List<ExamQuestionListViewEntity> getExamQuestionListByExamId(Integer examid);
	
	@Query("SELECT questionlist FROM ExamListViewEntity questionlist")
	List<ExamListViewEntity> getAllExamList();
	
	@Query("SELECT questionlist FROM ExamListViewEntity questionlist where examid in (:examid)")
	ExamListViewEntity getExamListByExamId(Integer examid);
	
	@Query("SELECT questionlist FROM ExamListViewEntity questionlist where departid in (:deparmentid)")
	List<ExamListViewEntity> getExamListByDepartmentId(Integer deparmentid);	
	
}
