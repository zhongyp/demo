package com.zhongyp.concurrency.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Example {

    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        System.out.println("start wait");
                        object.wait();
                        System.out.println("end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        System.out.println("start notify");
                        object.notify();
                        System.out.println("end notify");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
