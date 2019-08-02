package com.zhongyp.concurrent;

import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhongyp.
 * @date 2019/7/28
 */
public class ConcurrentLinkedQueueTest {

    @Test
    public void test(){
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    concurrentLinkedQueue.add(i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    concurrentLinkedQueue.add(100000+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    concurrentLinkedQueue.add(100000+100000+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    concurrentLinkedQueue.add(100000+100000+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<100000;i++){
                    concurrentLinkedQueue.add(100000+100000+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<100000;i++){
                    concurrentLinkedQueue.add(100000+100000+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<100000;i++){
                    concurrentLinkedQueue.add(100000+100000+i);
                }
            }
        }.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator iterator = concurrentLinkedQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(concurrentLinkedQueue.size());
    }
}
