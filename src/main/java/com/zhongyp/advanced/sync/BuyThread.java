package com.zhongyp.advanced.sync;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/20
 * mail: zhongyp001@163.com
 */
public class BuyThread implements Runnable{

    Demo demo;
    public BuyThread(Demo demo){
        this.demo =  demo;
    }
    @Override
    public void run() {
        demo.objectLockProduct();
    }
}