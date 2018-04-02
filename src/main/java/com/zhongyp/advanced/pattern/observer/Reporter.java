package com.zhongyp.advanced.pattern.observer;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Reporter extends Observable {

    public void getNewMessage(String msg){
        this.notifyAllObserver(msg);
    }
}
