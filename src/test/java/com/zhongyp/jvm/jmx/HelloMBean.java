package com.zhongyp.jvm.jmx;

/**
 * @author zhongyp.
 * @date 2019/7/30
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}
