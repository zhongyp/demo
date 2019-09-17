package com.zhongyp.advanced.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by camda on 2017/6/29.
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        TestServiceImpl testService = new TestServiceImpl();
        // 声明自己的处理类
        MyInvokeHandler myInvokeHandler = new MyInvokeHandler(testService);
        // 第一次生成代理类
        TestService proxy = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),new Class[]{TestService.class, TestService1.class},myInvokeHandler);
        // 第二次生成代理类，第二次生成的代理类从weakCache中直接获取，不再重新生成
        TestService proxy1 = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),new Class[]{TestService.class, TestService1.class},myInvokeHandler);
        // 代理类调用接口方法
        proxy.test();

        /**
         *
         * 使用构造器方法创建代理类实例
         */
        try {
            TestService t = testService.getClass().getConstructor(String.class).newInstance(new String("b"));
            t.test();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        /**
         * 用于将生成的代理类保存到A.class
         */
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "com.zhongyp.advanced.proxy.$Proxy0", new Class[]{TestService.class, TestService1.class}, 16);
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("A.class");
            outputStream.write(proxyClassFile);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }

    }
}



class TestServiceImpl implements TestService{
    @Override
    public void test(){
        System.out.println("我要开始测试啦");
    }

    @Override
    public void test3() {

    }
}

class MyInvokeHandler implements InvocationHandler{
    Object obj;
    public MyInvokeHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在反射调用之前，可以加一些处理行为
        // doSomeThing();
        method.invoke(obj,args);
        //在反射调用之后，也可以加一些处理行为
        // doSomeThing();
        return null;
    }
}