package com.zhongyp.spring.demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-annotation-beans.xml");
		Person p = (Person) ctx.getBean("person");
		p.testPrint();
	}
	
}
