package com.zhongyp.spring.demo.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof EmailEvent){
			EmailEvent emailEvent = (EmailEvent) arg0;
			System.out.println(emailEvent.getEmail());
			System.out.println(emailEvent.getText());
		}
	}

}
