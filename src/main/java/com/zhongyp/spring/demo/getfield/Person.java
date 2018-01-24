package com.zhongyp.spring.demo.getfield;

public class Person {

	private String name = "nihao";
	private Son son;
	private int age;

	public Person(){}
	public Person(String name){
		this.name = name;
	}
	
	
	
	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}
	
	public Son getSon() {
		return son;
	}
	
	public void setSon(Son son) {
		this.son = son;
	}

	public void printTest(){
		System.out.println("printTest");
	}
}
