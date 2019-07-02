package com.zhongyp.spring.demo.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhongyp.
 * @date 2019/7/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-init-bean.xml"})
public class TestInitBean {

    @Autowired
    InitBeanTest initBeanTest;

    /**
     * 测试InitializingBean接口的作用
     */
    @Test
    public void testInitBean(){

    }
}
