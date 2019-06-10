package com.zhongyp.concurrency.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StopThread {

    /**
     * stopRequest 变量的setter或者getter方法的synchronized并不是为了使得变量操作为原子操作
     * 不使用synchronized变量的操作也是原子的
     * 增加同步知识为了变量在多线程中的可见性。
     * --摘至  Effective Java 第二版
     */
    private static boolean stopRequest = false;// 共享变量，单独声明时对其他线程不可见

//    // synchronized保证共享变量的可见性
//    public static synchronized boolean isStopRequest() {
//        return stopRequest;
//    }
//
//    public static synchronized void setStopRequest(boolean stopRequest) {
//        StopThread.stopRequest = stopRequest;
//    }

    // 有待探索哦
    public static boolean isStopRequest() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            return stopRequest;
        }finally {
            lock.unlock();
        }
    }
    public static void setStopRequest(boolean stopRequest){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            stopRequest = stopRequest;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws Exception{
            Thread thread = new Thread(){
                @Override
                public void run(){
                    int i = 0;
                    while(!isStopRequest()){

                        try {
//                            System.out.printf(String.valueOf(stopRequest));
                            i ++;
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            };
            thread.start();
            TimeUnit.SECONDS.sleep(1);
            setStopRequest(true);
            System.out.printf(String.valueOf(stopRequest));


    }
}
