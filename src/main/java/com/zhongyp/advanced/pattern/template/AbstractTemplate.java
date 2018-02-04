package com.zhongyp.advanced.pattern.template;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public abstract class AbstractTemplate {
    abstract void play();
    abstract void go();

    public void doSomething(){
        System.out.println("模板方法");
    }
}
