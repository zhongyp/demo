package com.zhongyp.spring.demo.getfield;

import java.lang.reflect.Field;

import org.springframework.beans.factory.FactoryBean;

public class GetFieldFactoryBean implements FactoryBean<Object> {

	private String targetClass = null;
	private String targetField = null;
	
	public void setTargetClass(String targetclass){
		this.targetClass = targetclass;
	}
	
	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		Class<?> clazz = Class.forName(targetClass);
		Field field = clazz.getField(targetField);
		return field.get(null);
	}

	@Override
	public Class<? extends Object> getObjectType() {
		// TODO Auto-generated method stub
		return Object.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
