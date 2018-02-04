package com.zhongyp.advanced.pattern.status;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class GoodStatus implements Status {
    @Override
    public void handle() {
        System.out.println("好状态");
    }
}
