package com.zhongyp.concurrency.thread;


public class Ordered {
    volatile static boolean inited = false;
    volatile static Ordered ordered;
    public Ordered(){
        SleepUtils.sleep(1000);
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {// 第一个线程用来修改变量
            @Override
            public void run() {
                System.out.println("thread-1");
                ordered = new Ordered();// 语句1
                inited = true;
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {// 第二个线程用来验证变量
                System.out.println("thread-2");
//               SleepUtils.sleep(50);
                while (inited){
                    SleepUtils.sleep(0);
                }
                ordered.testPrint();// 语句2
            }
        }).start();
    }
    public void testPrint(){
        System.out.println("oooo");
    }
}