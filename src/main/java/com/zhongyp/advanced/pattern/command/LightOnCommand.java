package com.zhongyp.advanced.pattern.command;

/**
 * Created by Administrator on 2017/8/13.
 */
public class LightOnCommand implements Command {

    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {

    }
}
