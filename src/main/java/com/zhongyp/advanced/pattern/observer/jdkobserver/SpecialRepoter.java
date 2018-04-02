package com.zhongyp.advanced.pattern.observer.jdkobserver;

import java.util.Observable;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/26
 * mail: zhongyp001@163.com
 */
public class SpecialRepoter  extends Observable{

    public void getNewNews(String msg){
        this.setChanged();
        this.notifyObservers(msg);
    }
}
