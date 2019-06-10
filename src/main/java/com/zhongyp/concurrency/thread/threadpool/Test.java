package com.zhongyp.concurrency.thread.threadpool;

import java.util.LinkedList;
import java.util.concurrent.*;

public class Test {

    public volatile static boolean flag = false;

    public static void main(String[] args){
        ThreadOverHandler threadOverHandler = new ThreadOverHandler();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8,8, TimeUnit.SECONDS,new ArrayBlockingQueue<>(4),threadOverHandler);
        final Semaphore semaphore = new Semaphore(8, true);
        LinkedList<Future> futureList = new LinkedList<Future>();
        new Thread(

                () -> {
                    int timeout = 0;
                    int currentTaskCount = 0;
                    while(!threadPoolExecutor.isTerminated()){
                        try{

//                            if(currentTaskCount == threadPoolExecutor.getTaskCount()){
//                                if(timeout > 10){
//                                    threadPoolExecutor.shutdownNow();
//                                    threadOverHandler.setFlag(true);
//                                    flag = true;
//                                    System.out.println("线程死锁了");
//                                }else{
//                                    timeout++;
//                                }
//                            }else{
//                                currentTaskCount = (int) threadPoolExecutor.getTaskCount();
//                            }
                            try{
                                while(true){
                                    if(futureList.size() == 0&&!threadPoolExecutor.isTerminated()){
                                        Thread.sleep(500);
                                    }else{
                                        break;
                                    }
                                }
                                Future future = futureList.pop();
                                future.get(500, TimeUnit.MILLISECONDS);
                            }catch (Exception e){
                                e.printStackTrace();
                                System.out.println("又结束一个");
                            }
//                            Thread.sleep(1000);
//                            System.out.println(threadPoolExecutor.getActiveCount() +  ":" + threadPoolExecutor.getCompletedTaskCount() + " : " + threadPoolExecutor.getTaskCount());
                        }catch (Exception e){

                        }
                    }
                    System.out.println("It is over");
                }
        ).start();
        long start  = System.currentTimeMillis();
        for(int i=0; i<10; i++){
            if(flag){
               break;
            }
            System.out.println("放入第" + i);
            try{
                ((LinkedList<Future>) futureList).push(threadPoolExecutor.submit(new MyTasks(i)));
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        threadPoolExecutor.shutdown();
        while(true){
            if(threadPoolExecutor.isTerminated()){
                System.out.println("all the threads are shutdown !");
                break;
            }
        }
        for(Future future:futureList){
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis()-start);

    }

}



class MyTasks implements Runnable{

    private Semaphore semaphore;
    private int taskID;

    public MyTasks(int taskID){
        this.taskID = taskID;
    }
    int[] v;
    @Override
    public void run() {
        try{
//            semaphore.acquire();
            Thread.sleep(10000);
//            System.out.println(v[-1]);
//            throw new Exception("where am i?");

//            semaphore.release();
        }catch(Exception e){
//            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}


class ThreadOverHandler implements RejectedExecutionHandler {

    private boolean flag = false;

    public void setFlag(Boolean flag){
        this.flag = flag;
    }

    @Override
    public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
        while (true) {

            if (arg1.getQueue().size() >= arg1.getQueue()
                    .remainingCapacity()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(flag){
                break;
            } else {
                arg1.execute(arg0);
                break;
            }
        }
    }
}