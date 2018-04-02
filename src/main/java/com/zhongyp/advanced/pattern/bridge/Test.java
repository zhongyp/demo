package com.zhongyp.advanced.pattern.bridge;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */
public class Test {

    public static void main(String[] args){
        Shape shape = new Circular();
        Color color = new Red();
        shape.draw(color);
        Shape shape1 = new Square();
        Color color1 = new Green();
        shape1.draw(color1);
    }
}
