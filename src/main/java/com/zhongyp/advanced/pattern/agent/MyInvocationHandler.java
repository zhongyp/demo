package com.zhongyp.advanced.pattern.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/4.
 */
public class MyInvocationHandler implements InvocationHandler {
    Object obj;
    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Transaction t = new Transaction();
        t.beginC();
        Object result  = method.invoke(obj, args);
        t.endC();
        return null;
    }
}
