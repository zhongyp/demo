package com.zhongyp.advanced.pattern.abstractfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/1
 * mail: zhongyp001@163.com
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Banana createBanana() {
        return new SmallBanana();
    }
}
