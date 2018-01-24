package com.zhongyp.spring.demo.generics.BaseDaoImpl;

import com.zhongyp.spring.demo.generics.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("baseDaoImpl")
public class BaseDaoImpl implements BaseDao {

	@Override
	public void daoTest() {
		// TODO Auto-generated method stub
		System.out.println("daoTest");
		
	}

}
