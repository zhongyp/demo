package com.zhongyp.spring.demo.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

/**
 * @author zhongyp.
 * @date 2019/7/2
 */
public class InitBeanTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("完事了");
    }
    @Nullable
    private String value;
    public void setValue(String value){
        this.value = value;
    }
}
