package com.zhongyp.advanced.pattern.strategy;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class Meeting {

    private  Strategy strategy;
    public Meeting(Strategy strategy){
        this.strategy = strategy;
    }
    public void fire(){
        strategy.makeStrategy();
    }
}
