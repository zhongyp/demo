package com.zhongyp.advanced.pattern.agent;

/**
 *
 */
public class Test
{
    public static void main(String args[]) throws ClassNotFoundException {
        long start = System.currentTimeMillis();
        Student stu = new StudentProxy("com.zhongyp.advanced.pattern.agent.XiaoMing");
        stu = (Student) MyProxyFactory.getProxy(stu);
        stu.play("basket ball");
    }
}
