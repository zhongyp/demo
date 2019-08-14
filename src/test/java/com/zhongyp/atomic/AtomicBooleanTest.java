package com.zhongyp.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhongyp.
 * @date 2019/6/4
 */
public class AtomicBooleanTest {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicBoolean.compareAndSet(false, true);
        System.out.println(atomicBoolean);
    }
}

