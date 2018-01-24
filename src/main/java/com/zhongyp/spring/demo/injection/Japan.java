package com.zhongyp.spring.demo.injection;

public class Japan implements Person {
	
	private Gun gun;
	public Japan(Gun gun){
		this.gun = gun;
	}

	@Override
	public void useGun() {
		// TODO Auto-generated method stub
		System.out.println("日本人是傻逼");
	}

}
