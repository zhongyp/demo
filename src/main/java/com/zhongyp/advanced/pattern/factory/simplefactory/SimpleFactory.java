package com.zhongyp.advanced.pattern.factory.simplefactory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class SimpleFactory {
    Mouse createMouse(String type){
        if(type.equals("dell")){
            return new DellMouse();
        }else{
            return new HpMouse();
        }
    }
}
