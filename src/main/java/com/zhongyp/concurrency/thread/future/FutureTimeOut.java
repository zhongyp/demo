package com.zhongyp.concurrency.thread.future;

import java.util.concurrent.*;

public class FutureTimeOut {

    public static void main(String[] args) {
        final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4,
                1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.AbortPolicy());
        System.out.println(System.currentTimeMillis());
        ThreadTask threadTask = new ThreadTask();
        Future future = threadPool.submit(threadTask);
        try {
            System.out.println(future.get(5, TimeUnit.SECONDS));
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            future.cancel(true);
            e.printStackTrace();
        }
        threadPool.shutdown();
        while(threadPool.isTerminated()){
            System.out.println("game over");
        }
    }

}
class ThreadTask implements Callable{

    @Override
    public Object call() throws Exception {
//        int a = 5/0;
//        Thread.interrupted();
        System.out.println("提前结束了么？");
        Thread.sleep(5000);
        return null;
    }
}