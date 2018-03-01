package com.zhongyp.transaction;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */
public class StockException extends Exception {
    private static final long serialVersionUID = 5377570098437361228L;

    public StockException() {
        super();
    }

    public StockException(String message) {
        super(message);
    }

}