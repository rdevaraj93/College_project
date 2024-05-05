package com.example.demo.QuestionPatten;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
public class QuestionPatten {
	
	private QuestionDificalty onemarkquestion;
	private QuestionDificalty Twomarkquestion;
	private QuestionDificalty Fivemarkquestion;
	private QuestionDificalty Tenmarkquestion;
	
}
