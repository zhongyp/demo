package com.zhongyp.advanced.pattern.command;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class RemoteReceiver {

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    Light light = null;

    public void lightOn(){
        light.on();
    }
}
