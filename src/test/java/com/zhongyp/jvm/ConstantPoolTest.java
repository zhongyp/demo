package com.zhongyp.jvm;

import org.junit.Test;

/**
 * @author zhongyp.
 * @date 2019/7/29
 */
public class ConstantPoolTest {

    Integer i = 1;
    String a = "abc";
    final int c = 2;
    long b = 1;
    String str = new String("hhh");
    @Test
    public void test(){

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
