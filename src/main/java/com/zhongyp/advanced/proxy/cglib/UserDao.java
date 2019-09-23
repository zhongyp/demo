package com.zhongyp.advanced.proxy.cglib;

/**
 * @author zhongyp.
 * @date 2019/9/17
 */
public class UserDao implements Dao {

    @Override
    public void select() {
        System.out.println("UserDao 查询 selectById");
    }
    @Override
    public void update() {
        System.out.println("UserDao 更新 update");
    }
}
