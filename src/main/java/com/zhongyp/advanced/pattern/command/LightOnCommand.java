package com.zhongyp.advanced.pattern.command;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class LightOnCommand implements Command {

    RemoteReceiver remoteReceiver = null;
    public LightOnCommand(RemoteReceiver remoteReceiver){
        this.remoteReceiver = remoteReceiver;
    }

    @Override
    public void execute() {
        remoteReceiver.lightOn();
    }

    @Override
    public void undo() {

    }
}
