package com.zhongyp.advanced.pattern.command;

import com.sun.org.apache.regexp.internal.RE;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class Main {
    public static void main(String[] args){
        Light light = new Light();
        Control control = new Control();
        RemoteReceiver receiver = new RemoteReceiver();
        Command command = new LightOnCommand(receiver);
        receiver.setLight(light);
        control.setCommand(command);
        control.lightOnAction();

    }
}
