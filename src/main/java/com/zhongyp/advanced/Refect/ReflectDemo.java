package com.zhongyp.advanced.Refect;

import java.lang.reflect.*;


/**
 * Created by Administrator on 2017/6/20.
 */
public class ReflectDemo {

    public static void main(String arsg[]) throws Exception{
        //加载Class对象
        Class<?> clazz =  Class.forName("com.zhongyp.advanced.Refect.User");
        Method mtd = clazz.getMethod("setName", String.class);
        //实例化Class对象
        Object obj = (Object)clazz.newInstance();
        mtd.invoke(obj,"camda");
    }

}
