package com.zhongyp.spring.demo.init.circularref;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhongyp.
 * @date 2019/7/31
 */
public class A implements InitializingBean {
    B b;

    public A(B b) {
        this.b = b;
    }

//    public void setB(B b) {
//        this.b = b;
//    }

    public void test(){
        System.out.println("success!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        b.test();
    }
}
