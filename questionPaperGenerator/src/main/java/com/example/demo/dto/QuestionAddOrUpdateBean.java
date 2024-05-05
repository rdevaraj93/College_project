package com.example.demo.dto;

import com.example.demo.Entity.DepartmentViewEntiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionAddOrUpdateBean {

	private Integer questionId;
	private String  questionuniid;
	private String 	questionDescription;
	private Integer	departId;
	private Integer	subjectId;
	private Integer	unitId;	 
	private Integer	difficultyId;	
	private Integer	termId;	
	private Integer	questWeightAgeId;	
	private String 	isImportant;
	private String 	isRepeat;
	private String 	isValid;
	private Integer	createUserId;	
	private Integer	updatedUserId;
	
	
	
	public QuestionAddOrUpdateBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionAddOrUpdateBean(Integer questionId, String questionuniid, String questionDescription, Integer departId, Integer subjectId,
			Integer unitId, Integer difficultyId, Integer termId, Integer questWeightAgeId, String isImportant,
			String isRepeat, String isValid, Integer createUserId, Integer updatedUserId) {
		super();
		this.questionId = questionId;
		this.questionuniid = questionuniid;
		this.questionDescription = questionDescription;
		this.departId = departId;
		this.subjectId = subjectId;
		this.unitId = unitId;
		this.difficultyId = difficultyId;
		this.termId = termId;
		this.questWeightAgeId = questWeightAgeId;
		this.isImportant = isImportant;
		this.isRepeat = isRepeat;
		this.isValid = isValid;
		this.createUserId = createUserId;
		this.updatedUserId = updatedUserId;
	}


	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public String getQuestionDescription() {
		return questionDescription;
	}


	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}


	public Integer getDepartId() {
		return departId;
	}


	public void setDepartId(Integer departId) {
		this.departId = departId;
	}


	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public Integer getUnitId() {
		return unitId;
	}


	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}


	public Integer getDifficultyId() {
		return difficultyId;
	}


	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}


	public Integer getTermId() {
		return termId;
	}


	public void setTermId(Integer termId) {
		this.termId = termId;
	}


	public Integer getQuestWeightAgeId() {
		return questWeightAgeId;
	}


	public void setQuestWeightAgeId(Integer questWeightAgeId) {
		this.questWeightAgeId = questWeightAgeId;
	}


	public String getIsImportant() {
		return isImportant;
	}


	public void setIsImportant(String isImportant) {
		this.isImportant = isImportant;
	}


	public String getIsRepeat() {
		return isRepeat;
	}


	public void setIsRepeat(String isRepeat) {
		this.isRepeat = isRepeat;
	}


	public String getIsValid() {
		return isValid;
	}


	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}


	public Integer getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}


	public Integer getUpdatedUserId() {
		return updatedUserId;
	}


	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}	
	
	
	
	
	
}
