package com.example.demo.Dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.QuestionPatten.ExamPatten;
import com.example.demo.Utils.Config;

import lombok.Getter;
import lombok.Setter;
@RestController
@RequestMapping("/nithish/")
public class TestRun {
	
	@GetMapping("/Stringaccess")
	public String getnithishinputnumber(@RequestBody String name)
	
	{
		System.out.println("hai this is working " + name);
		return  name;
	}

	@GetMapping("/integeraccess")
	public Integer getintegeraccess(@RequestBody Integer age)
	{
		System.out.println("hai yr age is " + age);
		return  age;
	}
	//@GetMapping()

}
