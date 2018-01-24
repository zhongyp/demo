package com.zhongyp.spring.demo.generics.UserServiceImpl;

import com.zhongyp.spring.demo.generics.BaseServiceImpl.BaseServiceImpl;
import com.zhongyp.spring.demo.generics.UserService;
import org.springframework.stereotype.Component;
import com.zhongyp.spring.demo.generics.User;

@Component("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	public void userTest(){
		System.out.println("userTest");
	}
}
