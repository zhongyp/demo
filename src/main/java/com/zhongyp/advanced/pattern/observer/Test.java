package com.zhongyp.advanced.pattern.observer;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Test {
    public static void main(String args[]){

        Reporter reporter = new Reporter();
        CCTV cctv = new CCTV(reporter);
        reporter.getNewMessage("PGONE 玩嫂子啦！！");


    }
}
