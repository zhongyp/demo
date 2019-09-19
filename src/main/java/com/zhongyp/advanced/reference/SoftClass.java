package com.zhongyp.advanced.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author zhongyp.
 * @date 2019/9/18
 */
public class SoftClass extends SoftReference {
    public SoftClass(Object referent) {
        super(referent);
    }

    public SoftClass(Object referent, ReferenceQueue q) {
        super(referent, q);
    }
}
