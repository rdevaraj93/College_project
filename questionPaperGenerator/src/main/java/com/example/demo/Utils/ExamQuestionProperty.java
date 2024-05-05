package com.example.demo.Utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@PropertySource("applicationexam.yml")
public class ExamQuestionProperty {

	public Integer property_exam_is_ten_mark; 
	public Integer property_exam_is_twenty_mark; 
	public Integer property_exam_is_fifty_mark; 
	public Integer property_exam_is_hundred_mark; 
	
	public Integer property_easy_id; 
	public Integer property_medium_id; 
	public Integer property_hard_id;
	
	public Integer property_one_mark_id; 
	public Integer property_two_mark_id; 
	public Integer property_five_mark_id; 
	public Integer property_ten_mark_id;  
	
}
