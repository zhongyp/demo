package com.zhongyp.transaction;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */
public interface IStockProcessService {
    void openAccount(String aname, double money);
    void openStock(String sname, int amount);
    void buyStock(String aname, double money, String sname, int amount) throws StockException;
}
