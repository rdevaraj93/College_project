package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionPaperAddOrDeleteBean {
	
	private Integer newQuestionpaperID;
	private String examName;
	private Integer departmentID;
	private Integer subjectID;
	private List<Integer> unitIDList;
	private Integer totalexammark;
	private String issuppotoptional;
	//private JSONArray questionlist;
	

}
