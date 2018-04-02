package com.zhongyp.spring.demo.format;

public class Main {
	public static void main(String args[]) {
		
//		Test dt = new Test("I");
//		dt.greet("she");
		Animal animal = new Dog();
		animal.eat();
//		long start = System.currentTimeMillis();
//		PlayGame p = new CF();
//		System.out.println(System.currentTimeMillis() - start);
//		start = System.currentTimeMillis();
//		PlayGame p1 = new CF();
//		p1.display();
//		System.out.println(System.currentTimeMillis() - start);
	}

	String name;

	public Main(String personName) {
	    name = personName;
	    }

	public String greet(String yourName) {
		System.out.println(String.format("Hi %2$s, my name is %1$s", name, yourName));
		return String.format("Hi %2$s, my name is %1$s", name, yourName);
	}

}
