package com.zhongyp.advanced.pattern.factory.functionfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Test {
    public static void main(String[] args){
        KeyboFactory keyboFactory = new DellKeyboFactory();
        Keybo keybo = keyboFactory.createKeybo();
        keybo.ad();
    }
}
