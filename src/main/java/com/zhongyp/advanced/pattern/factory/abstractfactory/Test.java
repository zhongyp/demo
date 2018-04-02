package com.zhongyp.advanced.pattern.factory.abstractfactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Test {


    public static void main(String[] args){
        PcFactory aa = new DellFactory();
        Mouse mouse = (Mouse) aa.createKeybo();
        Keybo keybo = (Keybo) aa.createMouse();
        mouse.ad();
        keybo.ad();
    }
}
