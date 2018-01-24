package com.zhongyp.advanced.pattern.command;

/**
 * Created by Administrator on 2017/8/13.
 */
public class RemoteReceiver {

    Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void pressLightButton(){
        command.execute();
    }
}
