package com.zhongyp.basic;

import org.junit.Test;

/**
 * @author zhongyp.
 * @date 2019/7/28
 */
public class GrammerTest {

    @Test
    public void test(){

        start: for(int i=0;i<10;i++){
            System.out.println(i);
            for(int j=0;j<10;j++){
                if(j==2){
                    continue;
                }
                System.out.println(j);
            }
        }
    }
}
