package com.zhongyp.advanced.sync;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/20
 * mail: zhongyp001@163.com
 */
public class SailThread implements Runnable{
    Demo demo;
    public SailThread(Demo demo){
        this.demo =  demo;
    }
    @Override
    public void run() {
        demo.objectLockSail();
    }
}
