package com.zhongyp.advanced.pattern.observer;

/**
 * Created by Administrator on 2017/7/24.
 */
public class CurrentDisplayCard implements Observer,DisplayElement {
    private String str;
    private WeatherObserver wo;

    public CurrentDisplayCard(WeatherObserver wo){
        this.wo = wo;
        wo.register(this);
    }

    @Override
    public void update(String str){
        this.str = str;
    }
    @Override
    public void play() {
        System.out.println(str);
    }
}
