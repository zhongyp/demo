package com.zhongyp.spring.demo.factory;

public class Cat implements Being {

	private String msg;
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	@Override
	public void testBeing() {
		// TODO Auto-generated method stub
		System.out.println("è" + msg);
	}

}
