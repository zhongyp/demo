package com.zhongyp.concurrent;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Thread.activeCount;
import static java.lang.Thread.sleep;

/**
 * @author zhongyp.
 * @date 2019/7/28
 */
public class CopyAndWriteListTest {

    @Test
    public void test(){
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i=0;i<10000;i++){
            copyOnWriteArrayList.add(10000-i);
        }
        new Thread(){
            @Override
            public void run(){
                for (int i=0;i<10000;i++){
                    copyOnWriteArrayList.set(i, i);
                    System.out.println("write：" + i);
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run(){
                for (int i=0;i<10000;i++){
                    System.out.println(copyOnWriteArrayList.get(0));
                }
            }
        }.start();
        if(activeCount()>0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
