package com.zhongyp.spring.demo.transaction;

import com.zhongyp.transaction.IStockProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhongyp.
 * @date 2019/8/16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-transaction.xml"})
public class TestTransaction {


    @Autowired
    IStockProcessService iStockProcessService;


    /**
     * 用来测试Spring事务管理器管理的事务方法，对于突然退出的程序怎么处理
     */
    @Test
    public void testSpringTransactionFunc(){

        iStockProcessService.testBuy();
    }

}
