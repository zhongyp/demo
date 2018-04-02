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
        Command command = new LightOnCommand(light);
        RemoteReceiver receiver = new RemoteReceiver();
        receiver.exeCommand(command);

    }
}
