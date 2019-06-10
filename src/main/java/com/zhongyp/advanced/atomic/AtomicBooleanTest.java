package com.zhongyp.advanced.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

