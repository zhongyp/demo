package com.zhongyp.advanced.sync;

public class VolatileDemo {

    volatile int a = 0;
    public void sum(){
        a++;
    }
    public static void main(String[] args){
        final VolatileDemo vd = new VolatileDemo();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<10000;j++){
                        vd.sum();
                    }
                }

            }.start();
        }
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(vd.a);
    }

}
