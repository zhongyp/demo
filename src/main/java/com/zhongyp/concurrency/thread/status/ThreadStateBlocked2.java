package com.zhongyp.concurrency.thread.status;

import com.zhongyp.concurrency.thread.SleepUtils;

public class ThreadStateBlocked2 {

    public static void main(String[] args) {
        SyncLock sl = new SyncLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sl){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                sl.reduce();

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sl){
                    notifyAll();
                    SleepUtils.sleep(100000);
                }
//                sl.increase();
            }
        }).start();
    }
}

class SyncLock{
    private int count = 0;

    public synchronized void increase(){
        count++;
        notifyAll();
        SleepUtils.sleep(100000);

    }
    public synchronized void reduce(){

        try {
            wait();
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}