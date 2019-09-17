package com.zhongyp.advanced.refect;

/**
 * Created by Administrator on 2017/6/20.
 */
public class User {

    static {
        System.out.println("弄啥嘞!");
    }

    String name;
    public void setName(String name){
        System.out.println("我是" + name);
    }
}
