package com.zhongyp.advanced.pattern.decorator;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/1/24
 * mail: zhongyp001@163.com
 */
public class Test {
    public static void main(String[] args){
        Decorator decorator = new AnnimalDecorator();
        Decorator decorator1 = new PeopleDecorator();
        Decorator decorator2 = new SpeakDecorator();
        Decorator decorator3 = new BarkDecorator();
        decorator2.dodo(decorator);
        decorator3.dodo(decorator1);
    }
}
