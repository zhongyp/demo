package com.zhongyp.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/29
 * mail: zhongyp001@163.com
 */
public class LRUTest<K, V> extends LinkedHashMap<K, V> {


    private int cacheSize;

    public LRUTest(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
