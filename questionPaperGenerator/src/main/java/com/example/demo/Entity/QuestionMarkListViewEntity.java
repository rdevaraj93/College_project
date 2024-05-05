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
@Table(name = "vw_question_weight")
public class QuestionMarkListViewEntity {

	@Id
	@Column(name="ques_weight_id_pk")
	private Integer questionmarkid;

	@Column(name="weight_age")
	private String questionmarkweight;
}
