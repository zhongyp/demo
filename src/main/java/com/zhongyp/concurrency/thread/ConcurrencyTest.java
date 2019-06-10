package com.zhongyp.concurrency.thread;

public class ConcurrencyTest {

    public static final long count = 1000000;//循环次数
    public static void main(String[] args) throws InterruptedException{
        concurrency();
        serial();
    }
    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();
        // 新建线程用于测试线程的上下文切换
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i=0; i<count; i++){
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i=0; i<count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrentcy:" + time + "ms, b=" + b );
    }
    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i=0; i<count; i++){
            a += 5;
        }
        int b = 0;
        for (long i=0; i<count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b + ",a = " + a);
    }
}
