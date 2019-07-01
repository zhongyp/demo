package com.zhongyp.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zhongyp.
 * @date 2019/6/28
 */
public class RedisUtils {
    @Autowired
    RedisTemplate redisTemplate;

    public void test(){

    }
}
