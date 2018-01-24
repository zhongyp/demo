package com.zhongyp.advanced.pattern.agent;

/**
 * Created by Administrator on 2017/7/4.
 */
public class Main
{
    public static void main(String args[]) throws ClassNotFoundException {
//        long start = System.currentTimeMillis();
//        Student stu = new StudentProxy("com.camda.advanced.pattern.XiaoMing");
////        stu.play(" basketball");
//        System.out.println(System.currentTimeMillis()-start);
//        start = System.currentTimeMillis();
//        XiaoMing xm = new XiaoMing();
////        xm.play(" basketball");
//        System.out.println(System.currentTimeMillis()-start);
        Student stu = new XiaoMing();
        Student xm = (Student) MyProxyFactory.getProxy(stu);
        xm.play(" basketball");


    }
}
