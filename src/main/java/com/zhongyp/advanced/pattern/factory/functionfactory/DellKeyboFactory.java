package com.zhongyp.advanced.pattern.factory.functionfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class DellKeyboFactory implements KeyboFactory {
    @Override
    public Keybo createKeybo() {
        return new DellKeybo();
    }
}
