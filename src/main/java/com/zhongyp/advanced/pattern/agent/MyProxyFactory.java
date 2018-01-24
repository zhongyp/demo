package com.zhongyp.advanced.pattern.agent;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/7/4.
 */
public class MyProxyFactory {
    public static Object getProxy(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
