package com.zhongyp.advanced.pattern.visitor;

import java.util.Random;

/**
 * @author zhongyp.
 * @date 2019/9/18
 */
public class Manager extends Staff {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}