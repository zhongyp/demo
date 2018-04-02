package com.zhongyp.advanced.pattern.observer.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/26
 * mail: zhongyp001@163.com
 */
public class PeopleDaily extends NewspaperOffice implements Observer {
    private Observable observable;

    public PeopleDaily(SpecialRepoter repoter){
        this.observable = repoter;
        repoter.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof SpecialRepoter){
            System.out.println("People's Daily brings you the latest news!");

        }
    }

    public void remove(){
        observable.deleteObserver(this);
    }
}
