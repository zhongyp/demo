package com.zhongyp.advanced.classloading;

/**
 * @author zhongyp.
 * @date 2019/9/5
 */
public class InitClass {

    /**
     * static 仅会初始化一次，即使在多个线程同时创建多个实例的情况下
     */
    static{
        try {
            System.out.println("开始喽!");
            Thread.sleep(3000);
            System.out.println("完蛋鸟!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
