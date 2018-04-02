package com.zhongyp.threadpool;

import java.util.concurrent.*;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/16
 * mail: zhongyp001@163.com
 */
public class Test {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            Runnable worker = new WorkerThread("" + i);
//            executor.execute(worker);
//        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//        }
//        System.out.println("Finished all threads");


        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        ThreadPoolMonitorThread monitor = new ThreadPoolMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for(int i=0; i<10; i++){
            executorPool.execute(new WorkerThread("cmd"+i));
        }
        try {
            Thread.sleep(30000);
            executorPool.shutdown();
            Thread.sleep(5000);
            monitor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
