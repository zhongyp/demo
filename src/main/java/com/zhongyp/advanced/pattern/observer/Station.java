package com.zhongyp.advanced.pattern.observer;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface Station {

    public void register(User obs);
    public void notifyAllUser();
    public void remove(User obs);
}
