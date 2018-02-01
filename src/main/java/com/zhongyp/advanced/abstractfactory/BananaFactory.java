package com.zhongyp.advanced.abstractfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/1
 * mail: zhongyp001@163.com
 */
public class BananaFactory implements FruitFactory {
    @Override
    public Banana createBanana() {
        return new BigBanana();
    }
}
