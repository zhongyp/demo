package com.zhongyp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyp.
 * @date 2019/8/11
 */
public class MemoryLeak {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List list1 = new ArrayList<>();
        String longText = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int i=0;
        while (1<2)
        {
            JVMTestObject jvmTestObject = new JVMTestObject("name");
            list.add(jvmTestObject);
            jvmTestObject = null;
            i++;
            list1.add(longText + i);
        }
    }
}
