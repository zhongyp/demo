package com.zhongyp.spring.demo.context;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent{

	private String email = null;
	private String text = null;
	public EmailEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public EmailEvent(Object source, String email, String text){
		super(source);
		this.email = email;
		this.text = text;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
