package com.example.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vw_exam_question_list")
public class ExamQuestionListViewEntity implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="exam_ques_id_pk")
	private Integer examquestionid;

	@Column(name="exam_id_fk")
	private Integer examid;

	@Column(name="exam_name")
	private String examname;

	@Column(name="total_mark")
	private Integer totalmark;

	@Column(name="is_optional_support")
	private String isoptionalsupport;

	@Column(name="is_active")
	private String isactive;

	@Column(name="exam_created_date")
	private String examcreateddate;

	@Column(name="question_id_pk")
	private Integer questionid;
	
	@Column(name="Question_ID")
	private String question_id;

	@Column(name="question_Description")
	private String questiondescription;

	@Column(name="depart_id_fk")
	private Integer departmentid;

	@Column(name="depart_name")
	private String departmentname;
	
	@Column(name="subject_id_fk")
	private Integer subjectidfk;

	@Column(name="subject_name")
	private String subjectname;


	@Column(name="terms_id_fk")
	private Integer termsid;

	@Column(name="term_Name")
	private String termname;

	@Column(name="unit_id_fk")
	private Integer unitid;

	@Column(name="unit_name")
	private String unitname;

	@Column(name="difficulty_id_fk")
	private Integer difficultyid;

	@Column(name="difficulty_description")
	private String difficultydescription;

	@Column(name="ques_weight_id_fk")
	private Integer questionweightid;

	@Column(name="weight_age")
	private String weightage;

	@Column(name="IS_importent")
	private String isimportent;

	@Column(name="is_repeat")
	private String isrepeat;

	@Column(name="is_valid")
	private String isvalid;

	@Column(name="created_used_id_fk")
	private Integer createdusedid;

	@Column(name="created_user_Name")
	private String createdusername;

	@Column(name="created_time_stamp")
	private String createdtimestamp;
	
}
