package com.zhongyp.advanced.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhongyp.
 * @date 2019/9/17
 */
public class Test {
    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        // 设置超类，cglib是通过继承来实现的
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(logInterceptor);

        // 创建代理类
        Dao dao = (Dao)enhancer.create();

        dao.update();
        dao.select();
    }
}
