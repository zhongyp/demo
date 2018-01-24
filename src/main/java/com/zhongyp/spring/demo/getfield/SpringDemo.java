package com.zhongyp.spring.demo.getfield;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class SpringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-demo-factory-beans.xml");
		System.out.println(ctx.getBean("factory"));
		Son son = (Son) ctx.getBean("factory");
		System.out.println(son.getAge());
	}

}
