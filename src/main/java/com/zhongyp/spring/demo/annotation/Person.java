package com.zhongyp.spring.demo.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
	
	private PersonService personService;
	
	@Autowired
	@Resource(name="personService")
	public void setPersonService(PersonService personService){
		this.personService = personService;
	}

	public void testPrint(){
		System.out.println("I am OK");
		personService.printTest();
	}
	
}
