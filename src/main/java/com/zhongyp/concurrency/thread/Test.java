package com.zhongyp.concurrency.thread;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    int a = 0;
    boolean flag = false;

    public void writer(){
        a = 1; // 1
        flag = true; // 2
    }
    public void reader(){
        if (flag){ // 3
            int i = a * a; // 4
//            System.out.println(i);
        }
    }

    public static void main(String[] args) {


        Thread thread = new InterruptIOBlockedThread1();
        thread.start();
        System.out.println(thread.isInterrupted());
//        thread.interrupt();
        System.out.println(thread.isInterrupted());

//        SleepUtils.sleep(10);


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int java.lang.a = 0;
//                java.lang.a++;
//                System.out.println(java.lang.a);
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
//        });
//        thread.start();
//        thread.interrupt();
//        SleepUtils.sleep(1);
//        System.out.println(thread.isInterrupted());

//        for (int i=0;i<100000;i++){
//            new Thread(new ThreadA()).start();
//        }
    }
}

class InterruptIOBlockedThread1 extends Thread{
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        super.run();
        try {

//            queue.take();
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            System.out.println(br.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class ThreadA implements Runnable{
    @Override
    public void run() {
        Test test = new Test();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                test.writer();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.reader();
            }
        });
        thread.start();
        thread1.start();
    }
}