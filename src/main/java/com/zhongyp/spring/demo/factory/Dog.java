package com.zhongyp.spring.demo.factory;

public class Dog implements Being {

	private String msg = null;
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	@Override
	public void testBeing() {
		// TODO Auto-generated method stub
		System.out.println("��" + msg);
	}

}
