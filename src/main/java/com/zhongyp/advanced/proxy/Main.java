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

        MyInvokeHandler myInvokeHandler = new MyInvokeHandler(testService);

        TestService proxy = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),new Class[]{TestService.class, TestService1.class},myInvokeHandler);

        TestService proxy1 = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),new Class[]{TestService.class, TestService1.class},myInvokeHandler);

        proxy.test();

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


interface TestService{

    void test();
    void test3();
}

interface TestService1{

    void test1();
    void test4();
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
        method.invoke(obj,args);
        return null;
    }
}