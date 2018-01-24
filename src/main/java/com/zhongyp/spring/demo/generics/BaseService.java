package com.zhongyp.spring.demo.generics;

public interface BaseService<T> {
	
	public <T> void serviceTest(T entity);

}
