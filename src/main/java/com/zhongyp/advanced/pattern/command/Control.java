package com.zhongyp.advanced.pattern.command;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public class Control {


    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    Command command = null;
    public void lightOnAction(){
        command.execute();
    }
}
