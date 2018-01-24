package com.zhongyp.spring.demo.internaltionalsupport;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-message-beans.xml");
		String hello = ctx.getMessage("hello" , new String[]{"ʵʩ"}, Locale.getDefault(Locale.Category.FORMAT));
		String now = ctx.getMessage("now", new Object[]{new Date()}, Locale.getDefault(Locale.Category.FORMAT));
		System.out.println(hello);
		System.out.println(now);
	}

}
