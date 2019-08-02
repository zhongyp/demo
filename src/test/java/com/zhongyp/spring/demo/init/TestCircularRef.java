package com.zhongyp.spring.demo.init;

import com.zhongyp.spring.demo.init.circularref.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhongyp.
 * @date 2019/7/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-circularref-beans.xml"})
public class TestCircularRef {

    @Autowired
    private A a;

    @Test
    public void test(){
        System.out.println("开始了！");
    }

}
