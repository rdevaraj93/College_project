package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.QuestionDeficaltyViewEntity;
import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.Entity.QuestionMarkListViewEntity;
import com.example.demo.Entity.SubjectViewList;
import com.example.demo.Entity.UnitListViewEntity;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;

public interface QuestionService {
	
	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean);

	public List<QuestionListViewEntiry> getAllQuestionlist();
	
	public List<QuestionListViewEntiry> getAllQuestionListBydeparmnt(Integer departmentid);

	public QuestionListViewEntiry getQuestionById(Integer questionid);
	
	public List<QuestionDeficaltyViewEntity> getQuestionDeficalty();
	
	public List<QuestionMarkListViewEntity> getQuestionMarkList();
	
	public List<UnitListViewEntity> getUnitList();
	
	public List<SubjectViewList> getSubjectNameList();
	
}
