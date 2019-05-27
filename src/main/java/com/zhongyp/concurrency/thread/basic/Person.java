package com.zhongyp.concurrency.thread.basic;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/16
 * mail: zhongyp001@163.com
 */
public class Person {

    static int dd = 5;
    public synchronized void buy(int i){


        if(i==1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我买" + i + "个苹果");
    }

    public void sail(int i){
        String a = "AA";
        synchronized (Person.class){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我卖" + i + "个苹果");
        }
    }
    public void setDD(int i){
        dd = i;
    }
    public int getDD(){
        return dd;
    }
}
