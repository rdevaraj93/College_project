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
@Table(name = "vw_subject")
public class SubjectViewList {

	 
	@Id
	@Column(name="subject_id_pk")
	private Integer subjectidpk;

	@Column(name="subject_name")
	private String subjectname;
	
}
