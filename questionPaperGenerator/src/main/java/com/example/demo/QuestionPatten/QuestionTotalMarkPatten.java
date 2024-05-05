package com.example.demo.QuestionPatten;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
public class QuestionTotalMarkPatten {
	
	private QuestionPatten totaltenmark;
	private QuestionPatten totaltwentymark;
	private QuestionPatten totalfiftymark;
	private QuestionPatten totalhundredmark;
}
