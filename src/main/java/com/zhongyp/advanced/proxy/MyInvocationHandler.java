package com.zhongyp.advanced.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * Created by camda on 2017/6/29.
 */
public class MyInvocationHandler implements InvocationHandler{
    Object target;
    public MyInvocationHandler(Object target){
        this.target = target;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("我的代理处理程序");
        method.invoke(target,args);
        return null;
    }
}
