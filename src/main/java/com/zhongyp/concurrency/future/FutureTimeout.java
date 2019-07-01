package com.zhongyp.concurrency.future;

import java.util.concurrent.*;

/**
 * @author zhongyp.
 * @date 2019/6/20
 */
public class FutureTimeout {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Executor executor = Executors.newSingleThreadExecutor();
        Future future = ((ExecutorService) executor).submit(new Task());
        try {
            future.get(2000, TimeUnit.MILLISECONDS);
            System.out.println("等待：" + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Exception: " + (System.currentTimeMillis() - start));
//            future.cancel(true);
            e.printStackTrace();
        }
        ((ExecutorService) executor).shutdown();
        System.out.println("hehe：" + (System.currentTimeMillis() - start));
        while (true){
            if(((ExecutorService) executor).isTerminated()){
                System.out.println("结束：" + (System.currentTimeMillis() - start));
                break;
            }
        }
    }
}
class Task implements Callable{

    @Override
    public Object call() throws Exception {
        Thread.sleep(20000);
        return null;
    }
}
