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
@Table(name = "tm_question_difficulty")
public class QuestionDeficaltyViewEntity {

	@Id
	@Column(name="difficulty_id_pk")
	private Integer difficultyidpk;

	@Column(name="difficulty_description")
	private String difficultydescription;
	
}
