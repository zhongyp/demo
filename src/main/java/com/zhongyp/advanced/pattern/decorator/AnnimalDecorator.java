package com.zhongyp.advanced.pattern.decorator;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class AnnimalDecorator implements Decorator {
    @Override
    public void dodo(Decorator decorator) {
        System.out.println("我是动物");
    }
}
