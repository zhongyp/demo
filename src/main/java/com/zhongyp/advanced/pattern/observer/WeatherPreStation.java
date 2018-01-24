package com.zhongyp.advanced.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/24.
 */
public class WeatherPreStation implements Station {
    private ArrayList list;
    private User obs;
    private String weather = "好天气";
    public WeatherPreStation(){
        list = new ArrayList();
    }

    @Override
    public void register(User obs) {
        list.add(obs);
    }

    @Override
    public void notifyAllUser() {
        Iterator it = list.iterator();
        while(it.hasNext()){
            User obs = (User) it.next();
            obs.update(getStr());
        }
    }

    @Override
    public void remove(User obs) {
        int i = list.indexOf(obs);
        if(i>0){
            list.remove(obs);
        }
    }

    public String getStr(){
        return weather;
    };


}
