package com.zhongyp.advanced.pattern.observer;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface Subject {

    public void register(Observer obs);
    public void notifyA();
    public void remove(Observer obs);
}
