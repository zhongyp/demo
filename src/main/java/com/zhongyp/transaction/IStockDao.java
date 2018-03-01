package com.zhongyp.transaction;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */
public interface IStockDao {

    void insertStock(String sname, int amount);

    void updateStock(String sname, int amount, boolean isBuy);

}
