package com.zhongyp.advanced.proxy;

/**
 * Created by camda on 2017/6/29.
 */
public class IPhone implements Phone {
    @Override
    public void call(String name){
        System.out.println(name);
    }
    @Override
    public void sendMsg(String msg){
        System.out.println(msg);
    }
}
