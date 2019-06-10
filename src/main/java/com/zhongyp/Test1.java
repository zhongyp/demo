package com.zhongyp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) {
        Test1 test = new Test1();
        test.test();
    }

    public void test(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6));
        List list = new ArrayList();
        int i=0;
        for (i=0; i<5; i++){
            list.clear();
            list.add(i);
            threadPoolExecutor.submit(new Test2(i,list));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GG");

    }
    class Test2 implements Callable {

        private int num;
        private List list;
        Test2(int num, List list){
            this.num = num;
            this.list = list;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(num);
            System.out.println("gg:" + list.get(0));
            return null;
        }
    }
}
