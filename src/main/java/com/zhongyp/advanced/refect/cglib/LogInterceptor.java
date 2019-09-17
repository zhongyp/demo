package com.zhongyp.advanced.refect.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhongyp.
 * @date 2019/9/17
 */
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 注意这里是调用 invokeSuper 而不是 invoke，否则死循环，methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
        before();
        Object result = methodProxy.invokeSuper(object, objects);
        after();
        return result;
    }

    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}
