package com.zhongyp.atomic;

import org.junit.Test;
import sun.awt.A;

/**
 * @author zhongyp.
 * @date 2019/8/17
 */
public class TestClassLoaderWare {

    @Test
    public void test(){
        A a = new A();
        System.out.println(a.getClass().getClassLoader());

    }
}
