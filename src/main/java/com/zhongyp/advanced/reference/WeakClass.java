package com.zhongyp.advanced.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author zhongyp.
 * @date 2019/9/18
 */
public class WeakClass extends WeakReference {
    public WeakClass(Object referent, ReferenceQueue q) {
        super(referent, q);
    }
}
