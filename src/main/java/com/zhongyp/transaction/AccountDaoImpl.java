package com.zhongyp.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/1
 * mail: zhongyp001@163.com
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public void insertAccount(String aname, double money) {
        String sql = "insert into account(aname, balance) values(?,?)";
        this.getJdbcTemplate().update(sql, aname, money);
    }

    @Override
    public void updateAccount(String aname, double money, boolean isBuy) {
        String sql = "update account set balance=balance+? where aname=?";
        if (isBuy) {
            sql = "update account set balance=balance-? where aname=?";
        }
        this.getJdbcTemplate().update(sql, money, aname);

    }

}
