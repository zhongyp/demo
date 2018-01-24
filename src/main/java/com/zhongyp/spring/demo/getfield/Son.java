package com.zhongyp.spring.demo.getfield;

public class Son {
	
	private String name;
	private String age;
	
	public Son(){}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Son(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

}
