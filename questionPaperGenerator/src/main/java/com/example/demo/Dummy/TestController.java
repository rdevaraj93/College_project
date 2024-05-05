package com.example.demo.Dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.QuestionPatten.ExamPatten;
import com.example.demo.Utils.Config;

import lombok.Getter;
import lombok.Setter;



 
@Getter
@Setter
@RestController
@RequestMapping("/Test/")
@Component
//@PropertySource("application.yml")
public class TestController {

	@Autowired
    private Config config;
	
	//@Autowired
	//private TenMarkConfig tenmarkconfig;
	
	@Autowired
	private ExamPatten tenmarkconfig;
	
	@GetMapping("/ymaltest/")
	public void getTest() {
		System.out.println("TEST" +   " " +  config.toString() );
		System.out.println("tenmarkconfig" +   " " +  tenmarkconfig.toString() );
		
		System.out.println("getOnemarkques " +tenmarkconfig.getWithoptional().getTotalhundredmark().getTenmarkquestion().getHard() );
		 
//		System.out.println("getFivemarkques " + getTenmarkconfig().getFivemarkques());
//		System.out.println("getTenmarkques " + getTenmarkconfig().getTenmarkques());
	}


	 
}
