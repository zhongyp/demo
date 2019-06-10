package com.zhongyp.concurrency.thread;

public class SleepUtils {
    public static void sleep(long mills){
        try{
            Thread.sleep(mills*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
