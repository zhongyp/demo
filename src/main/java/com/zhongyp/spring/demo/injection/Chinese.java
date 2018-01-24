package com.zhongyp.spring.demo.injection;

public class Chinese implements Person{
	
	private Gun gun;
	
	public void setGun(Gun gun){
		this.gun = gun;
	}

	@Override
	public void useGun() {
		// TODO Auto-generated method stub
		System.out.println("我是中国人哎" + gun.fire());
	}
	
	
	
}
