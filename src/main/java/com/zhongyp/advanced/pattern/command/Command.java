package com.zhongyp.advanced.pattern.command;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/4
 * mail: zhongyp001@163.com
 */
public interface Command {
    void execute();
    void undo();
}
