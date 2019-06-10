package com.zhongyp.concurrency.thread;

public class ByteClass {
    public static void main(String[] args) {

        ByteClassDemo byteClassDemo = new ByteClassDemo();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//                byteClassDemo.setCount(2);
//                byteClassDemo.getCount();
//            }
//        }).start();
    }
}


class ByteClassDemo{
    private int count = 0;

//    public synchronized int getCount() {
//        count ++;
//        return count;
//    }
//
//    public synchronized void setCount(int count) {
//        count ++;
//        this.count = count;
//    }
    public synchronized void test1(){
        int count = 0;
        count ++;
    }
//    public void test(){
//        synchronized (this){
//            int count = 0;
//            count ++;
//        }
//    }
}
