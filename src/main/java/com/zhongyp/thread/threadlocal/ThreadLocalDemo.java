package com.zhongyp.thread.threadlocal;

import java.util.Map;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class ThreadLocalDemo {


//    public static class CommonThread extends Thread {
//        Map<Integer, Integer> cacheMap = new HashMap<>();
//    }
//
//    public static class CustomThreadLocal {
//        private int defaultValue;
//
//        public CustomThreadLocal(int value) {
//            defaultValue = value;
//        }
//
//        public Integer get() {
//            Integer id = this.hashCode();
//            Map<Integer, Integer> cacheMap = getMap();
//            if (cacheMap.containsKey(id)) {
//                return cacheMap.get(id);
//            }
//            return defaultValue;
//        }
//
//        public void set(int value) {
//            Integer id = this.hashCode();
//            Map<Integer, Integer> cacheMap = getMap();
//            cacheMap.put(id, value);
//        }
//
//        public Map<Integer, Integer> getMap() {
//            CommonThread thread = (CommonThread) Thread.currentThread();
//            return thread.cacheMap;
//        }
//    }

    public static class Number{
        private int value = 10;
        public void increase() throws Exception{
            value = 10;
            Thread.sleep(10);
            System.out.println(value);
        }
        public void decrease() throws Exception{
            value = -10;
            Thread.sleep(10);
            System.out.println(10);
        }
    }


    public static void main(String[] args){
        final Number number = new Number();

//        Thread thread1 = new CommonThread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    number.increase();
//                }catch (Exception e){
//
//                }
//
//            }
//        });
//        Thread thread2 = new CommonThread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    number.decrease();
//                }catch (Exception e){
//
//                }
//            }
//        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    number.increase();
                }catch (Exception e){

                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    number.decrease();
                }catch (Exception e){

                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
