package com.zhongyp.spring.demo.generics;

import com.zhongyp.spring.demo.generics.UserServiceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-t-beans.xml");
		UserServiceImpl us = (UserServiceImpl) ctx.getBean("userService");
		us.userTest();
		us.serviceTest(new User());
		
	}
}
