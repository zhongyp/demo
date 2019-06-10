package com.zhongyp.spring.demo.mock;

public class FakeQuest implements Quest{
    @Override
    public void test() {
        System.out.println("faker quest");
    }
}
