package com.zhongyp.thread.latchcyclicbarrier.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/29
 * mail: zhongyp001@163.com
 */
public class Work implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    public Work(CountDownLatch downLatch, String name){
        this.downLatch = downLatch;
        this.name = name;
    }


    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();
    }

    private void doWork(){
        System.out.println(this.name + "正在干活!");
    }
}
