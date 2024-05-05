package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ExamListViewEntity;
import com.example.demo.Entity.ExamQuestionListViewEntity;
import com.example.demo.Service.QuestionPaperGeneraterService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;

@RestController
@RequestMapping("/generate/")
@CrossOrigin("http://localhost:3000/")
public class QuestionPaperGeneraterController {
	
	@Autowired
	QuestionPaperGeneraterService questionpapergeneraterservice;
	
	@PostMapping("/newquestionpaper")
	public ProcedureOutputResponceBean generateNewQuestionPaper(@RequestBody QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) { 
		
		return questionpapergeneraterservice.generateNewQuestionPaper(questionpaperaddordeletebean);
		
	}
	
	@DeleteMapping("/questiondelete/{examid}")
	public ProcedureOutputResponceBean deleteExistingQuestionPaper(@PathVariable Integer examid) {
		 
		System.out.println("you called question paper delete");
		return questionpapergeneraterservice.deleteQuestionPaper(examid);

	}
	
	
	@GetMapping("/getallexamquestion")
	public List<ExamQuestionListViewEntity> getExamQuestionList() { 
		System.out.println("you called question paper delete");
		return questionpapergeneraterservice.getExamQuestionList();
		
	}
	
	@GetMapping("/getexamquestion/{examid}")
	public List<ExamQuestionListViewEntity> getExamQuestionListByExamId(@PathVariable Integer examid) { 
		System.out.println("you called question paper delete");
		return questionpapergeneraterservice.getExamQuestionListByExamId(examid);
		
	}

	@GetMapping("/getallexamList")
	public List<ExamListViewEntity> getAllExamList() { 
		System.out.println("you called getAllExamList");
		return questionpapergeneraterservice.getAllExamList();
	}
	
	@GetMapping("/getexamList/{examid}")
	public ExamListViewEntity getExamListByExamId(@PathVariable Integer examid) { 
		System.out.println("you called getAllExamList");
		return questionpapergeneraterservice.getExamListByExamId(examid);
	}
	
	@GetMapping("/getdepartexamList/{deparmentid}")
	public List<ExamListViewEntity> getExamListByDepartmentId(@PathVariable Integer deparmentid) { 
		System.out.println("you called getAllExamList");
		return questionpapergeneraterservice.getExamListByDepartmentId(deparmentid);
	}
	
	
	
	
}
