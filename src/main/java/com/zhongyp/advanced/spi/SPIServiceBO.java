package com.zhongyp.advanced.spi;

/**
 * @author zhongyp.
 * @date 2019/5/28
 */
public class SPIServiceBO implements SPIService {
    @Override
    public String getSPIName(){
        return "SPIServiceBO";
    }
}
