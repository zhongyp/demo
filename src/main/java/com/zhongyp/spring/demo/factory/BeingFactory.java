package com.zhongyp.spring.demo.factory;

public class BeingFactory {

	public static Being getBeing(String str){
		if(str.equalsIgnoreCase("dog")){
			return new Dog();
		}else{
			return new Cat();
		}
	}
	
}
