package com.zhongyp.advanced.pattern.strategy;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class BigStrategy implements Strategy {

    @Override
    public void makeStrategy() {
        System.out.println("制定个大策略");
    }
}
