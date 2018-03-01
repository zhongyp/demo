package com.zhongyp.transaction;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */
public interface IAccountDao {
    void insertAccount(String aname, double money);

    void updateAccount(String aname, double money, boolean isBuy);
}
