package com.zhongyp.concurrency.thread;

public class Visible {
    private static boolean flag;

//    public static boolean isFlag() {
//        return flag;
//    }
//
//    public static void setFlag(boolean flag) {
//        Visible.flag = flag;
//    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(!flag){
                    i++;
                }
            }
        }).start();
        SleepUtils.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                flag = true;
            }
        }).start();
//        flag = true;
    }
}
