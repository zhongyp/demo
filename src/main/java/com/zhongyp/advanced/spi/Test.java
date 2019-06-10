package com.zhongyp.advanced.spi;

import java.util.ServiceLoader;

/**
 * @author zhongyp.
 * @date 2019/5/28
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<SPIService> serializers = ServiceLoader.load(SPIService.class);
        for (SPIService spiService:serializers){
            System.out.println(spiService.getSPIName());
        }
    }
}
