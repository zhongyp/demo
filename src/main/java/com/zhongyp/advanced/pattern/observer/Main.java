package com.zhongyp.advanced.pattern.observer;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Main {
    public static void main(String args[]){

        Station station = new WeatherPreStation();
        CurrentDisplayCard currentDisplayCard = new CurrentDisplayCard(station);
        station.notifyAllUser();
        currentDisplayCard.play();

    }
}
