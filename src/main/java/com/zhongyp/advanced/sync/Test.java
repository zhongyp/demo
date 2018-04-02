package com.zhongyp.advanced.sync;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/20
 * mail: zhongyp001@163.com
 */
public class Test {

    public static void main(String[] args){
        Demo demo = new Demo();
        for(int i=0;i<10;i++){
            new Thread(new BuyThread(demo)).start();
        }
        for(int i=0;i<10;i++){
            new Thread(new SailThread(demo)).start();
        }
    }
}
