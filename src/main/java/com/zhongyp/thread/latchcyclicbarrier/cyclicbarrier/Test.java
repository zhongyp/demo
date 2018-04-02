package com.zhongyp.thread.latchcyclicbarrier.cyclicbarrier;

import java.util.concurrent.*;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/29
 * mail: zhongyp001@163.com
 */
public class Test {


    public static void main(String[] args){
        Executor executor = new ThreadPoolExecutor(4,5,3, TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CycWork work1 = new CycWork(cyclicBarrier, "one");
        CycWork work2 = new CycWork(cyclicBarrier, "two");
        CycWork work3 = new CycWork(cyclicBarrier, "three");
        executor.execute(work1);
        executor.execute(work2);
        executor.execute(work3);
    }
}
