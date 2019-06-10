package com.zhongyp.concurrency.thread;

public class DaemonThread {
    public static void main(String[] args) {

    }
    static class DaemonRunner implements Runnable{
        @Override
        public void run(){
            try {
//                SleepUtils.second(10000);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
