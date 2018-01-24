package com.zhongyp.advanced.pattern.command;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Client {
    public static void main(String[] args){
        //需要开的灯
        Light light = new Light();
        //开灯命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        //远程接收者
        RemoteReceiver remoteReceiver = new RemoteReceiver();

        remoteReceiver.setCommand(lightOnCommand);
        remoteReceiver.pressLightButton();

    }
}
