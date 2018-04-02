package com.zhongyp.advanced.pattern.bridge;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Square implements Shape {
    @Override
    public void draw(Color color) {
        System.out.print("画" + color.print() + "正方形");
    }
}
