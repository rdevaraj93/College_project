package com.example.demo.Entity;

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
@Table(name = "vw_exam_list")
public class ExamListViewEntity {
	
	@Id
	@Column(name="Exam_id_pk")
	private Integer examid;

	@Column(name="Exam_name")
	private String examname;

	@Column(name="Depart_id_fk")
	private Integer departid;
	
	@Column(name="depart_name")
	private String departname;
	
	@Column(name="subject_id_fk")
	private Integer subjectidfk;
	
	@Column(name="subject_name")
	private String subjectname;

	@Column(name="Total_mark")
	private Integer totalmark;

	@Column(name="is_optional_support")
	private String isoptionalsupport;

	@Column(name="is_active")
	private String isactive;

	@Column(name="created_date")
	private String examcreateddate;
}
