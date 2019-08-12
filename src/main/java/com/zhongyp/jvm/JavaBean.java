package com.zhongyp.jvm;

import com.zhongyp.advanced.over.hide.A;

/**
 * @author zhongyp.
 * @date 2019/8/9
 */
public class JavaBean{
    private int value = 1;
    private Integer hello = 3;
    public String s = "abc";
    public final static int f = 0x101;
    A a = new A();
    public void setValue(int v){
        final int temp = 3;
        this.value = temp + v;
    }

    public int getValue(){
        return value;
    }
}
