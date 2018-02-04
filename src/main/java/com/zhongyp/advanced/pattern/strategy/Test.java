package com.zhongyp.advanced.pattern.strategy;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class Test {
    public static void main(String[] args){
        FlyBehavior behavior = new FlyWithWings();
        Duck duck = new Duck(behavior);
        duck.fly();
    }

}
