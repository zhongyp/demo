package com.zhongyp.advanced.pattern.facade;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class Computer {
    public void start(){
        new CPU().start();
        new Memory().start();
        new Disk().start();
        System.out.println("电脑启动啦！");
    }

    public void shutdown(){

    }
}
