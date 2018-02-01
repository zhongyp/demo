package com.zhongyp.advanced.pattern.factory;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/1
 * mail: zhongyp001@163.com
 */
public class AnnimalFactory {

    public Annimal createAnnimal(String name){
        Annimal animal = null;
        if(name.equals("duck")){
            animal = new Duck();
        }else{
            animal = new Bird();
        }
        return animal;

    }
}
