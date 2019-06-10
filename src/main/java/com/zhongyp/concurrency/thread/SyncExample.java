package com.zhongyp.concurrency.thread;

public class SyncExample {

    private int count=0;

    public  int getCount() {
        synchronized(this){
            return count;
        }

    }

    public synchronized void setCount() {
        synchronized(this){
            count++;
        }

    }
}
