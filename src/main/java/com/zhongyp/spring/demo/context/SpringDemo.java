package com.zhongyp.spring.demo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-event-beans.xml");
		EmailEvent ee = new EmailEvent("test" , "spring@qq.com" , "�յ�û");
		ctx.publishEvent(ee);
	}
}
