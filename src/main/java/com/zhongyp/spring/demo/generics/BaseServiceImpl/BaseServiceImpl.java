package com.zhongyp.spring.demo.generics.BaseServiceImpl;

import com.zhongyp.spring.demo.generics.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongyp.spring.demo.generics.BaseDao;

@Service("baseServiceImpl")
public class BaseServiceImpl<T> implements BaseService {

	private BaseDao dao;
	@Autowired
	public void setBaseDao(BaseDao dao){
		
		this.dao = dao;
	}
	@Override
	public void serviceTest(Object entity) {
		// TODO Auto-generated method stub
		System.out.println("serviceTest");
		System.out.println(dao + "\n" + entity);
		dao.daoTest();
	}
	
	
	
	

}
