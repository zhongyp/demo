package com.zhongyp.spring.demo.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	public static void main(String args[]) throws Exception{

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-beans.xml");
		Chinese chn = (Chinese) ctx.getBean("chinese");
		chn.useGun();
		Japan jp = (Japan) ctx.getBean("japan");
		jp.useGun();
	}
}
