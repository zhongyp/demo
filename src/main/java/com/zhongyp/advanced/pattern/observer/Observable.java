package com.zhongyp.advanced.pattern.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Observable {

    Vector<Observer> vector = new Vector();

    public synchronized void addObserver(Observer observer){
        vector.add(observer);
    }

    public synchronized void removeObserver(Observer observer){
        vector.remove(observer);
    }

    public void notifyAllObserver(String msg){
        Iterator iterator = vector.iterator();
        while(iterator.hasNext()){
            Observer observer = (Observer) iterator.next();
            observer.update(msg);
        }
    }
}
