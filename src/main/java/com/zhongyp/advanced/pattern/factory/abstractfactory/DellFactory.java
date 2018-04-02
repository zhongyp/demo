package com.zhongyp.advanced.pattern.factory.abstractfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class DellFactory implements PcFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new DellKeybo();
    }
}
