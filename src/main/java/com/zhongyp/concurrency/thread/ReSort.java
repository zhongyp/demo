package com.zhongyp.concurrency.thread;

public class ReSort {
    static volatile int a=0,b=0,x=3,y=4;
    public static void main(String[] args) {

        /**
         * 这段代码用来校验cpu对内存的读/写操作，不一定与内存实际发生的读/写顺序一致。
         */
        Thread thead = new Thread(new Runnable() {
            @Override
            public void run() {
                b=2; // B1
                y=a; // B2
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1; // A1
                x = b; // A2
            }
        });
        thead.start();
        thread1.start();
        System.out.println();

    }
}
