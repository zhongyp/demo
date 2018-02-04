package com.zhongyp.advanced.pattern.strategy;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly in the sky");
    }
}
