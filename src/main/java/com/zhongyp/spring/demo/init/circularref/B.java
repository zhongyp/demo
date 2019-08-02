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

//    public void setA(A a) {
//        this.a = a;
//    }

    public void test(){
        a.test();
    }
}
