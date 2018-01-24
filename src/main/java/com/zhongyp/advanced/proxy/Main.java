package com.zhongyp.advanced.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by camda on 2017/6/29.
 */
public class Main {
    public static void main(String args[]){
        InvocationHandler handler = new MyInvocationHandler(new IPhone());
        Phone p = (Phone) Proxy.newProxyInstance(Phone.class.getClassLoader(),new Class[]{Phone.class},handler);
        p.call("john");
    }
}
