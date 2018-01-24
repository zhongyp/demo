package com.zhongyp.advanced.pattern.command;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface Command {
    void execute();
    void undo();
}
