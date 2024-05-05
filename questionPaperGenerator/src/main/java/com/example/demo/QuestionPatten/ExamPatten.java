package com.example.demo.QuestionPatten;

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
@ConfigurationProperties("mark")
@PropertySource("application.yml")
public class ExamPatten {

	private QuestionTotalMarkPatten withoutoptional;
	private QuestionTotalMarkPatten withoptional;
}
