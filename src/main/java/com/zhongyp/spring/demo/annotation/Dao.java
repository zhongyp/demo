package com.zhongyp.spring.demo.annotation;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class Dao {
	
	public void insert(){
		System.out.println("�������������ݵ�");
	}

}
