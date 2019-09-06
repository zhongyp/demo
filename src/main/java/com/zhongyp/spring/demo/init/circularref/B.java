package com.zhongyp.spring.demo.init.circularref;

/**
 * @author zhongyp.
 * @date 2019/7/31
 */
public class B {

    A a;

    public B(A a) {
        this.a = a;
    }

//    public void setA(A java.lang.a) {
//        this.java.lang.a = java.lang.a;
//    }

    public void test(){
        a.test();
    }
}
