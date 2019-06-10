package com.zhongyp.concurrency.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class InterruptThreadTest {
    public static void main(String[] args) {

    }
}

class InterruptCurrentThread extends Thread{

    @Override
    public void run() {
        super.run();
        this.interrupt();
    }
}
class InterruptBlockedThread extends Thread{

    @Override
    public void run() {
        super.run();
        SleepUtils.sleep(100);
    }
}
class InterruptIOBlockedThread extends Thread{
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    @Override
    public void run() {
        super.run();
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class InterruptNormalThread extends Thread{
    @Override
    public void run() {
        super.run();

    }
}
