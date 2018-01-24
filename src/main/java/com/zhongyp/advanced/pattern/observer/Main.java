package com.zhongyp.advanced.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Main {
    public static void main(String args[]){
//        WeatherObserver wo = new WeatherObserver();
//        CurrentDisplayCard cdc = new CurrentDisplayCard(wo);
//        wo.notifyA();
//        cdc.play();
        List list = new ArrayList();
        list.add("hello");
        list.add(",");
        list.add("world");
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
    }
}
