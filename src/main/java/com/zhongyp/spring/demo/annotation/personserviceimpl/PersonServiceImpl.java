package com.zhongyp.spring.demo.annotation.personserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongyp.spring.demo.annotation.Dao;
import com.zhongyp.spring.demo.annotation.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	
	
	private Dao dao;
	
	@Autowired
	public void setDao(Dao dao){

		this.dao = dao;
	}

	@Override
	public void printTest() {
		// TODO Auto-generated method stub
		System.out.println("She is Ok");
		dao.insert();
	}
	

}
