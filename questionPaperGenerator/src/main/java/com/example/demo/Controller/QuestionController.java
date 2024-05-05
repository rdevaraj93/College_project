package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.QuestionDeficaltyViewEntity;
import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.Entity.QuestionMarkListViewEntity;
import com.example.demo.Entity.SubjectViewList;
import com.example.demo.Entity.UnitListViewEntity;
import com.example.demo.Service.QuestionService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;


@RestController
@RequestMapping("/question/")
@CrossOrigin("http://localhost:3000/")
public class QuestionController {

	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/getallquestion/")
	public List<QuestionListViewEntiry> getAllQuestionList() {
		System.out.println("called");
		return questionservice.getAllQuestionlist();
		
	}
	
	
	@GetMapping("/getallquestionbydeparmnt/{departmentid}")
	public List<QuestionListViewEntiry> getAllQuestionListBydeparmnt(@PathVariable Integer departmentid) {
		System.out.println(" Based on department" +departmentid);
		return questionservice.getAllQuestionListBydeparmnt(departmentid);
		
	}
	
	@GetMapping("/getquestionbyid/{questionid}")
	public QuestionListViewEntiry getQuestionById(@PathVariable Integer questionid ) {
		return questionservice.getQuestionById(questionid);

	}
	
	@PostMapping("/addquestion/")
	public ProcedureOutputResponceBean questionAdd(@RequestBody QuestionAddOrUpdateBean questionaddorupdatebean) {
		System.out.println("THis question controller called");
		return questionservice.questionAddOrUpdate(questionaddorupdatebean);
	
	}
	
	@PutMapping("/updatequestion/")
	public ProcedureOutputResponceBean questionUpdate(@RequestBody QuestionAddOrUpdateBean questionaddorupdatebean) {
		return questionservice.questionAddOrUpdate(questionaddorupdatebean);
	
	}
	
	@GetMapping("/getquestiondeficalty/")
	public List<QuestionDeficaltyViewEntity> getQuestionDeficalty() {
		return questionservice.getQuestionDeficalty();

	}	
	
	@GetMapping("/getquestionmarklist/")
	public List<QuestionMarkListViewEntity> getQuestionMarkList() {
		 
		return questionservice.getQuestionMarkList();	
	}
	
	@GetMapping("/getunitlist/")
	public List<UnitListViewEntity> getUnitList() {
	 
		return questionservice.getUnitList();	
	}	
	
	@GetMapping("/getsubjectnamelist/")
	public List<SubjectViewList> getSubjectNameList() {
		return questionservice.getSubjectNameList();	
	}	
	
}
