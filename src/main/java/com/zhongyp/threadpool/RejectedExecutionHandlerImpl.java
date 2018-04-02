package com.zhongyp.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/16
 * mail: zhongyp001@163.com
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + "被拒绝");
    }
}
