package com.zhongyp.advanced.classloading;

/**
 * @author zhongyp.
 * @date 2019/9/5
 */
public class InitClass {

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
