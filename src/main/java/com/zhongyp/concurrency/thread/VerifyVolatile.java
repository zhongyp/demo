package com.zhongyp.concurrency.thread;

public class VerifyVolatile {
    private static volatile int a = 0;
    private static int count = 10000;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<count; i++){
                    a++;
                }
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<count; i++){
                    a++;
                }
            }
        });
        thread1.start();
        while(thread.isAlive()||thread1.isAlive()){
            SleepUtils.sleep(10);
        }
        System.out.println(a);
    }
}
