package com.zhongyp.thread.latchcyclicbarrier.latch;

import java.util.concurrent.*;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/29
 * mail: zhongyp001@163.com
 */
public class Test {



    public static void main(String[] args){
        Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        CountDownLatch countDownLatch  = new CountDownLatch(3);
        Work work1 = new Work(countDownLatch,"one");
        Work work2 = new Work(countDownLatch,"two");
        Work work3 = new Work(countDownLatch,"three");
        Boss boss = new Boss(countDownLatch);
        executor.execute(boss);
        executor.execute(work1);
        executor.execute(work2);
        executor.execute(work3);


    }


}
