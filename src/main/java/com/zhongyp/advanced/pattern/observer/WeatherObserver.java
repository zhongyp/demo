package com.zhongyp.advanced.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/24.
 */
public class WeatherObserver implements Subject {
    private ArrayList list;
    private Observer obs;
    private String str;
    public WeatherObserver(){
        list = new ArrayList();
    }

    @Override
    public void register(Observer obs) {
        list.add(obs);
    }

    @Override
    public void notifyA() {
        Iterator it = list.iterator();
        while(it.hasNext()){
            Observer obs = (Observer) it.next();
            obs.update(getStr());
        }
    }

    @Override
    public void remove(Observer obs) {
        int i = list.indexOf(obs);
        if(i>0){
            list.remove(obs);
        }
    }

    public String getStr(){
        return "ABC";
    };
}
