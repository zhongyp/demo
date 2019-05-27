package com.zhongyp.concurrency.thread.latchcyclicbarrier.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/29
 * mail: zhongyp001@163.com
 */
public class CycWork implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;
    public CycWork(CyclicBarrier cyclicBarrier, String name){
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(this.name + "开始了");
        try{
            sleep(3000);
            cyclicBarrier.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(this.name + "干完了");
    }
}
