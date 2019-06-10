package com.zhongyp.aop;

public class AOPProxy {

    private Object targetClass;
    private Object aspectClass;

    public Object getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Object targetClass) {
        this.targetClass = targetClass;
    }

    public Object getAspectClass() {
        return aspectClass;
    }

    public void setAspectClass(Object aspectClass) {
        this.aspectClass = aspectClass;
    }

    public void invoke(){

    }
}
