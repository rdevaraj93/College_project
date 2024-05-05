package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ExamListViewEntity;
import com.example.demo.Entity.ExamQuestionListViewEntity;
import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.QuestionPatten.ExamPatten;
import com.example.demo.QuestionPatten.QuestionPatten;
import com.example.demo.Repository.QuestionPaperGeneraterDAORepository;
import com.example.demo.Repository.QuestionPaperRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Service.QuestionPaperGeneraterService;
import com.example.demo.Utils.ExamQuestionProperty;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;

@Service
public class QuestionPaperGeneraterServiceImpl implements QuestionPaperGeneraterService {

	@Autowired
	QuestionPaperGeneraterDAORepository  questionpapergeneraterdaorepository;
	
	@Autowired
	ExamPatten exampatten;
	
	@Autowired	
	QuestionPatten questionpatten;
	
	@Autowired 
	QuestionRepository questionrepository;
	
	@Autowired
	ExamQuestionProperty examquestionproperty;
	
	@Autowired
	QuestionPaperRepository questionpapaerrepository;
		
	
	public List<QuestionListViewEntiry> randomQuestionList(List<QuestionListViewEntiry> questionlist, Integer questionCount){
		
		Random random = new Random();
		List<QuestionListViewEntiry> tempList = new ArrayList<>();  
		for (int i = 0; i < questionCount; i++) { 
	            int randomIndex = random.nextInt(questionlist.size());
	            while(tempList.contains(questionlist.get(randomIndex))) {
	            	randomIndex = random.nextInt(questionlist.size());
	            }
	            tempList.add(questionlist.get(randomIndex));     
	        } 
		 return tempList;
	}
	
	public List<Integer> mergerandomQuestionList(List<QuestionListViewEntiry> tempList, List<Integer> onemarkquestionlist){
			 
		if (tempList.size() > 0) {						
			for (QuestionListViewEntiry questionEntity : tempList) 
				{
					onemarkquestionlist.add(questionEntity.getQuestionid());		 
				}
		}
		 return onemarkquestionlist;
	}
	
	public List<Integer> mergeQuestionList(List<Integer> tempList, List<Integer> onemarkquestionlist){
		 
		if (tempList.size() > 0) {						
			for (Integer questionEntity : tempList) 
				{
					onemarkquestionlist.add(questionEntity.intValue());		 
				}
		}
		 return onemarkquestionlist;
	}
	
	
	public Map<String, Integer> getQuestioncountbytotalmark(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean){

		Integer	totalonemarkquestioncount_easy;
		Integer	totalonemarkquestioncount_medium;
		Integer	totalonemarkquestioncount_hard;

		Integer	totaltwomarkquestioncount_easy;
		Integer	totaltwomarkquestioncount_medium;
		Integer	totaltwomarkquestioncount_hard;
		
		Integer	totalfivemarkquestioncount_easy;
		Integer	totalfivemarkquestioncount_medium;
		Integer	totalfivemarkquestioncount_hard;
		
		Integer	totaltenmarkquestioncount_easy;
		Integer	totaltenmarkquestioncount_medium;
		Integer	totaltenmarkquestioncount_hard;
	
		var required_exam_mark = questionpaperaddordeletebean.getTotalexammark();
		Map<String, Integer> questionMap = new HashMap<String, Integer>();		
		
		switch (required_exam_mark) {
		case 10:
			switch (questionpaperaddordeletebean.getIssuppotoptional()) {
			case "N":
				System.out.println("Working with 10 mark and support optional --> N");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotaltenmark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoutoptional().getTotaltenmark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotaltenmark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoutoptional().getTotaltenmark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoutoptional().getTotaltenmark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoutoptional().getTotaltenmark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotaltenmark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoutoptional().getTotaltenmark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotaltenmark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoutoptional().getTotaltenmark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoutoptional().getTotaltenmark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoutoptional().getTotaltenmark().getTenmarkquestion().getHard());	 								
				break;
			case "Y":
				System.out.println("Working with 10 mark and support optional--> Y");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoptional().getTotaltenmark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoptional().getTotaltenmark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoptional().getTotaltenmark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoptional().getTotaltenmark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoptional().getTotaltenmark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoptional().getTotaltenmark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoptional().getTotaltenmark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoptional().getTotaltenmark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoptional().getTotaltenmark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoptional().getTotaltenmark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoptional().getTotaltenmark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoptional().getTotaltenmark().getTenmarkquestion().getHard());	 								
				break;
			}
			break;
		case 20:
			switch (questionpaperaddordeletebean.getIssuppotoptional()) {
			case "N":
				System.out.println("Working with 20 mark and support optional --> N");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getHard());	 								
				break;
			case "Y":
				System.out.println("Working with 20 mark and support optional--> Y");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoptional().getTotaltwentymark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoptional().getTotaltwentymark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoptional().getTotaltwentymark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoptional().getTotaltwentymark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoptional().getTotaltwentymark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoptional().getTotaltwentymark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoptional().getTotaltwentymark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoptional().getTotaltwentymark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoptional().getTotaltwentymark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoptional().getTotaltwentymark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoptional().getTotaltwentymark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoptional().getTotaltwentymark().getTenmarkquestion().getHard());	 								
				break;
			}
			break;
		case 50:
			switch (questionpaperaddordeletebean.getIssuppotoptional()) {
			case "N":
				System.out.println("Working with 50 mark and support optional --> N");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotalfiftymark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoutoptional().getTotalfiftymark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotalfiftymark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoutoptional().getTotalfiftymark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoutoptional().getTotalfiftymark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoutoptional().getTotalfiftymark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotalfiftymark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoutoptional().getTotalfiftymark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotalfiftymark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoutoptional().getTotalfiftymark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoutoptional().getTotalfiftymark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoutoptional().getTotalfiftymark().getTenmarkquestion().getHard());	 								
				break;
			case "Y":
				System.out.println("Working with 50 mark and support optional--> Y");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoptional().getTotalfiftymark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoptional().getTotalfiftymark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoptional().getTotalfiftymark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoptional().getTotalfiftymark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoptional().getTotalfiftymark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoptional().getTotalfiftymark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoptional().getTotalfiftymark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoptional().getTotalfiftymark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoptional().getTotalfiftymark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoptional().getTotalfiftymark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoptional().getTotalfiftymark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoptional().getTotalfiftymark().getTenmarkquestion().getHard());	 								
				break;
			}
			break;
		case 100:
			switch (questionpaperaddordeletebean.getIssuppotoptional()) {
			case "N":
				System.out.println("Working with 100 mark and support optional--> N");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotalhundredmark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoutoptional().getTotalhundredmark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotalhundredmark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoutoptional().getTotalhundredmark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoutoptional().getTotalhundredmark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoutoptional().getTotalhundredmark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoutoptional().getTotalhundredmark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoutoptional().getTotalhundredmark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoutoptional().getTotalhundredmark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoutoptional().getTotalhundredmark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoutoptional().getTotalhundredmark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoutoptional().getTotalhundredmark().getTenmarkquestion().getHard());	 								
				break;
			case "Y":
				System.out.println("Working with 100 mark and support optional--> Y");
				questionMap.put("totalonemarkquestioncount_easy", 	exampatten.getWithoptional().getTotalhundredmark().getOnemarkquestion().getEasy());
				questionMap.put("totalonemarkquestioncount_medium",	exampatten.getWithoptional().getTotalhundredmark().getOnemarkquestion().getMedium());
				questionMap.put("totalonemarkquestioncount_hard",	exampatten.getWithoptional().getTotalhundredmark().getOnemarkquestion().getHard());

				questionMap.put("totaltwomarkquestioncount_easy",	exampatten.getWithoptional().getTotalhundredmark().getTwomarkquestion().getEasy());
				questionMap.put("totaltwomarkquestioncount_medium", exampatten.getWithoptional().getTotalhundredmark().getTwomarkquestion().getMedium());
				questionMap.put("totaltwomarkquestioncount_hard",  	exampatten.getWithoptional().getTotalhundredmark().getTwomarkquestion().getHard());

				questionMap.put("totalfivemarkquestioncount_easy", 	exampatten.getWithoptional().getTotalhundredmark().getFivemarkquestion().getEasy());
				questionMap.put("totalfivemarkquestioncount_medium",exampatten.getWithoptional().getTotalhundredmark().getFivemarkquestion().getMedium());
				questionMap.put("totalfivemarkquestioncount_hard",	exampatten.getWithoptional().getTotalhundredmark().getFivemarkquestion().getHard());

				questionMap.put("totaltenmarkquestioncount_easy",	exampatten.getWithoptional().getTotalhundredmark().getTenmarkquestion().getEasy());
				questionMap.put("totaltenmarkquestioncount_medium", exampatten.getWithoptional().getTotalhundredmark().getTenmarkquestion().getMedium());
				questionMap.put("totaltenmarkquestioncount_hard", 	exampatten.getWithoptional().getTotalhundredmark().getTenmarkquestion().getHard());	 								
				break;
			}
			break;
		}
				
		return questionMap;
			
	}
	
	public List<Integer> getALLExamQuestionList(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean, Integer Property_easy_id, Integer Property_medium_id, Integer Property_hard_id , Integer Property_one_mark_id, 
			Integer required_easy_question_count, Integer required_medium_question_count, Integer required_Hard_question_count ) {
		
		List<Integer> finalQuestionIDList 	= new ArrayList<Integer>();
		List<QuestionListViewEntiry> questionEasylist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(), questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),Property_easy_id, Property_one_mark_id);
		List<QuestionListViewEntiry> questionMediumlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),Property_medium_id, Property_one_mark_id);
		List<QuestionListViewEntiry> questionHardlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),	questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),Property_hard_id, Property_one_mark_id);
							 
		List<QuestionListViewEntiry> tempList = new ArrayList<>(); 
		
		tempList = randomQuestionList( questionEasylist , required_easy_question_count);
		finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
	
		tempList = randomQuestionList( questionMediumlist ,required_medium_question_count);
		finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
		
		tempList = randomQuestionList( questionHardlist , required_Hard_question_count);
		finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
		
		return finalQuestionIDList;
	}
	
	@Override
	public ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) {
		
		 
		List<Integer> finalQuestionIDList 	= new ArrayList<Integer>();
		List<Integer> finalList 	= new ArrayList<Integer>();
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();	
		
		// to store the required question count based easy, medium , hard
		Map<String,Integer> map = new HashMap<String,Integer>();
		map = getQuestioncountbytotalmark(questionpaperaddordeletebean);
				
							 					
		List<Integer> oneMarkSelecedQuestionList = getALLExamQuestionList(questionpaperaddordeletebean, examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_medium_id(),examquestionproperty.getProperty_hard_id(),  examquestionproperty.getProperty_one_mark_id(), map.get("totalonemarkquestioncount_easy"), map.get("totalonemarkquestioncount_medium"), map.get("totalonemarkquestioncount_hard"));
		List<Integer> twoMarkSelecedQuestionList = getALLExamQuestionList(questionpaperaddordeletebean, examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_medium_id(),examquestionproperty.getProperty_hard_id(),  examquestionproperty.getProperty_two_mark_id(),map.get("totaltwomarkquestioncount_easy"),map.get("totaltwomarkquestioncount_medium"),map.get("totaltwomarkquestioncount_hard"));
		List<Integer> fiveMarkSelecedQuestionList = getALLExamQuestionList(questionpaperaddordeletebean, examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_medium_id(),examquestionproperty.getProperty_hard_id(),  examquestionproperty.getProperty_five_mark_id(),map.get("totalfivemarkquestioncount_easy"), map.get("totalfivemarkquestioncount_medium"), map.get("totalfivemarkquestioncount_hard"));
		List<Integer> tenMarkSelecedQuestionList = getALLExamQuestionList(questionpaperaddordeletebean, examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_medium_id(),examquestionproperty.getProperty_hard_id(),  examquestionproperty.getProperty_ten_mark_id(),map.get("totaltenmarkquestioncount_easy"), map.get("totaltenmarkquestioncount_medium"), map.get("totaltenmarkquestioncount_hard"));

		finalQuestionIDList = mergeQuestionList(oneMarkSelecedQuestionList, finalQuestionIDList );
		finalQuestionIDList = mergeQuestionList(twoMarkSelecedQuestionList, finalQuestionIDList );
		finalQuestionIDList = mergeQuestionList(fiveMarkSelecedQuestionList, finalQuestionIDList );
		finalQuestionIDList = mergeQuestionList(tenMarkSelecedQuestionList, finalQuestionIDList );
				
		for (Integer questionEntity : finalQuestionIDList) 
		{
			System.out.println("****************************");
			System.out.println(" Exam Question  Id "+questionEntity.intValue());
		}
				
		finalList = finalQuestionIDList;
		
		return questionpapergeneraterdaorepository.generateNewQuestionPaper(questionpaperaddordeletebean, finalList);
	}

	@Override
	public ProcedureOutputResponceBean deleteQuestionPaper(Integer examid) {
		
		System.out.println("this service implementtion class");
		return questionpapergeneraterdaorepository.deleteQuestionPaper(examid);
		
	}

	@Override
	public List<ExamQuestionListViewEntity> getExamQuestionListByExamId(Integer examid) {	 	 
		return  questionpapaerrepository.getExamQuestionListByExamId(examid); 
	}
	
	@Override
	public List<ExamQuestionListViewEntity> getExamQuestionList() {	 	 
		return questionpapaerrepository.getExamQuestionList();
	}
	
	@Override
	public List<ExamListViewEntity> getAllExamList() {	 	 
		System.out.println("this service getAllExamList inde imple class");
		return questionpapaerrepository.getAllExamList();
	}
	
	@Override
	public  ExamListViewEntity getExamListByExamId(Integer examid) {
		
		System.out.println("this service implementtion class");
		return questionpapaerrepository.getExamListByExamId(examid);
		
	}
	
	@Override
	public  List<ExamListViewEntity> getExamListByDepartmentId(Integer deparmentid) {
		
		System.out.println("this service implementtion class");
		return questionpapaerrepository.getExamListByDepartmentId(deparmentid);
		
	}
	
	
	

}
