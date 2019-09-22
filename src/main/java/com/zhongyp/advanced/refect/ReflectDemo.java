package com.zhongyp.advanced.refect;

/**
 * Created by Administrator on 2017/6/20.
 */
public class ReflectDemo {

    public static void main(String arsg[]) throws Exception{

        // 反射获取Class对象， initialize参数实际的意义在于，true时执行类初始化（类加载阶段的初始化阶段），否则不初始化。
        Class<?> clazz1 =  Class.forName("com.zhongyp.advanced.refect.User", true, ReflectDemo.class.getClassLoader());
    }

}
