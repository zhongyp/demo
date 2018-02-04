package com.zhongyp.advanced.pattern.strategy;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class Duck {

    private FlyBehavior flyBehavior;
    public Duck(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public void fly(){
        flyBehavior.fly();
    }
}
