package com.zhongyp.advanced.Refect;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by Administrator on 2017/6/20.
 */
public class BeanWrapperDemo {

    public static void main(String args[]) throws Exception{
        Object obj = Class.forName("com.zhongyp.advanced.Refect.User").newInstance();
        BeanWrapper bean = new BeanWrapperImpl(obj);
        bean.setPropertyValue("name","zhongyp");
    }



}
