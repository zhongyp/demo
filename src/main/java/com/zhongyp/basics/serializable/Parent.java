package com.zhongyp.basics.serializable;

/**
 * @author zhongyp.
 * @date 2019/5/23
 */
public class Parent {
    private String a = "a";
    private String b;
    public String c = "c";

    public Parent(){

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Parent(String b){
        this.b = b;
    }
}
