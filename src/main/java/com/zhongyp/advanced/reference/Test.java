package com.zhongyp.advanced.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author zhongyp.
 * @date 2019/9/18
 */
public class Test {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        System.out.println(referenceQueue.poll());
        WeakReference weakReference = new WeakReference(new TestEntity(), referenceQueue);

        ((TestEntity) weakReference.get()).test();
        System.gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(((TestEntity) weakReference.get())==null){
            System.out.println("被清了！！！");
        }
    }
}
