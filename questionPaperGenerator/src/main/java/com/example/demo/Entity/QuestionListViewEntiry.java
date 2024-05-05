package com.example.demo.Entity;

import java.io.Serializable;
import java.security.Timestamp;

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
@Table(name = "vw_question_list")
public class QuestionListViewEntiry  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name="question_id_pk")
	private Integer questionid;
	
	@Column(name="question_id")
	private String questionuniid; 
	
	@Column(name="question_Description")
	private String questiondescription ;
	
	@Column(name="depart_id_fk")
	private Integer departmentID;
		
	@Column(name="depart_name")
	private String departmentName;
	
	@Column(name="subject_id_fk")
	private Integer subjectid;
	
	@Column(name="subject_name")
	private String subjectname;
	
	@Column(name="Terms_id_fk")
	private Integer termsid;
	
	@Column(name="Name")
	private String termsname;

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
	private String questionweightage;
	
	@Column(name="IS_importent")
	private String isimportent;
	
	@Column(name="is_repeat")
	private String isrepeat;
	
	@Column(name="is_valid")
	private String isvalid;
	
	@Column(name="created_used_id_fk")
	private Integer createduserid;
	
	@Column(name="created_user_Name")
	private String createdusername;

	@Column(name="created_time_stamp")
	private String createdtimestamp;
	

	 
	
	
}

