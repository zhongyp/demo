package com.zhongyp.concurrency.thread.basic;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/16
 * mail: zhongyp001@163.com
 */
public class Test {

    public static void main(String[] args){
        final Person person = new Person();
        final Person person1 = new Person();
        new Thread(){
            @Override
            public void run(){
                person.sail(1);
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                person1.sail(2);
            }
        }.start();
        int i=0;
        System.out.println("数量：" + i++);

    }




}
