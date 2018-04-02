package com.zhongyp.advanced.pattern.observer;

import com.zhongyp.advanced.pattern.observer.Observable;
import com.zhongyp.advanced.pattern.observer.Observer;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class CCTV implements Observer {

    Observable observable;

    public CCTV(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("最新消息！！！" + msg);
    }
}
