package com.zhongyp.concurrency.thread;

import java.io.*;

public class ThreadState {
    public static void main(String[] args) {

//        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
//        new Thread(new Waiting(),"Waiting").start();
//        new Thread(new Blocked(),"BlockedThread-1").start();
//        new Thread(new Blocked(),"BlockedThread-2").start();
        Account account = new Account();
        new Thread(()->{
            account.getMoney(100);

        },"thread get").start();
        new Thread(()->{

            account.putMoney(100);
        }, "thread put").start();
////        new Thread(new IOState(), "IOState").start();
//        Thread thread = new Thread(new IOState(), "IOState");
//        thread.setPriority(Thread.MAX_PRIORITY);
    }
    // 该线程不断的进行睡眠
    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            SleepUtils.sleep(200000);
        }
    }
    // 该线程在Waiting.class实例上等待
    static class Waiting implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (Waiting.class){//锁死Waiting字节码
                    try {
                        Waiting.class.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    // 该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized(Blocked.class){//锁死Blocked字节码
                SleepUtils.sleep(100000);
            }
        }
    }

    // wait reenter Blocked
    static class Account{
        private int money = 0;

        public synchronized void getMoney(int num){
            if(money>=num){
                money-=num;
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public synchronized void putMoney(int num){
            money+=num;
            notifyAll();
            SleepUtils.sleep(1000000);
        }

    }


    // IO阻塞的线程状态
    static class IOState implements Runnable{
        @Override
        public void run() {
            try {
                InputStreamReader is_reader = new InputStreamReader(System.in);
                String str = new BufferedReader(is_reader).readLine();
                System.out.printf(str);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}

