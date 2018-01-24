package com.zhongyp.spring.demo.format;

/**
 * Created by Administrator on 2017/7/19.
 */
public class CF implements PlayGame {

    public CF(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void display(){
        System.out.println("CF");
    }
}
