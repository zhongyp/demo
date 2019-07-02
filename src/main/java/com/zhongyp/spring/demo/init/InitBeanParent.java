package com.zhongyp.spring.demo.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

/**
 * @author zhongyp.
 * @date 2019/7/2
 */
public class InitBeanParent implements InitializingBean {
    @Nullable
    private String value;
    public void setValue(String value){
        this.value = value;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("不知道干啥" + this.value);
    }
}
