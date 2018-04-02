package com.zhongyp.advanced.proxy;

import java.lang.reflect.*;

/**
 * Created by camda on 2017/6/29.
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        InvocationHandler handler = new MyInvocationHandler(new IPhone());
//        Phone p = (Phone) Proxy.newProxyInstance(Phone.class.getClassLoader(),new Class[]{Phone.class},handler);
//        p.call("john");
//        Test test =  new Test();
//
//        Class clazz = Class.forName("com.zhongyp.advanced.proxy.Test");
//        Constructor[] constructors = clazz.getConstructors();
//        for(Constructor str:constructors){
//            System.out.println(str);
//        }
//
//        Method[] method = clazz.getDeclaredMethods();
//        for(Method method1:method){
//            System.out.println(method1);
//        }
//        Method method1 = clazz.getMethod("go", null);
//        method1.invoke(test,null);

        TestServiceImpl testService = new TestServiceImpl();

        MyInvokeHandler myInvokeHandler = new MyInvokeHandler(testService);

        TestService proxy = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),new Class[]{TestService.class},myInvokeHandler);

        proxy.test();
    }
}


class Test{


    public Test(){}

    private void test(){}
    public void go(){
        System.out.println("go");

    }

    public void gogogo(){
        System.out.println("gogogo");

    }

}


interface TestService{

    void test();
}

class TestServiceImpl implements TestService{
    @Override
    public void test(){
        System.out.println("我要开始测试啦");
    }
}

class MyInvokeHandler implements InvocationHandler{

    Object obj;
    public MyInvokeHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}