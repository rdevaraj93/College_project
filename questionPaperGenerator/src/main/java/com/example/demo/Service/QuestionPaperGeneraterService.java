package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.ExamListViewEntity;
import com.example.demo.Entity.ExamQuestionListViewEntity;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;

public interface QuestionPaperGeneraterService {

	ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean);
	
	ProcedureOutputResponceBean deleteQuestionPaper(Integer examid);
	
	List<ExamQuestionListViewEntity> getExamQuestionListByExamId(Integer examid);
	
	List<ExamQuestionListViewEntity> getExamQuestionList();
	
	ExamListViewEntity getExamListByExamId(Integer examid);
	
	List<ExamListViewEntity> getAllExamList();

	List<ExamListViewEntity> getExamListByDepartmentId(Integer deparmentid);
	
	
}
