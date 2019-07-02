package com.zhongyp.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyp.
 * @date 2019/7/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-data-redis.xml"})
public class TestRedis {

    @Autowired
    @Qualifier("testRedisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;


    @Test
    public void testSetAndGet(){
        redisTemplate.opsForValue().set("abctest","testabc");
        System.out.println(redisTemplate.opsForValue().get("abctest"));
    }

    /**
     * 测试序列化后的对象是否可以强制类型转换
     */
    @Test
    public void testHash(){
        HashMap map = new HashMap<>();
        List list = new ArrayList<>();
        list.add("aa");
        map.put("a","b");
        map.put("c","b");
        map.put("b","b");
        map.put("d","b");
        map.put("list", list);
        redisTemplate.opsForHash().put("hashkey", "test", map);
        Map map1 = redisTemplate.opsForHash().entries("hashkey");
        Map map2 = (Map) map1.get("test");
        System.out.println(map2.get("list"));
        System.out.println(redisTemplate.opsForHash().entries("hashkey"));

    }

    /**
     * 测试redis pipline
     * pipline是管道的意思
     * pipline可以支持一次执行多个命令，只获取一次connection，用于执行批量任务时，提高系统性能
     * 并不支持spring管理事务，如果需要事务管理，可以在回调方法中自己写事务控制
     */
    @Test
    public void testPipline(){
        System.out.println(redisTemplate.executePipelined(new RedisCallback <Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.multi();
                redisConnection.listCommands().lPush("123a".getBytes(), "abc".getBytes());
                redisConnection.listCommands().lPush("1234b".getBytes(), "abc3".getBytes());
//                int b = 1/0;
                redisConnection.listCommands().lPush("1235c".getBytes(), "abc4".getBytes());
                redisConnection.listCommands().lPush("1236d".getBytes(), "abc5".getBytes());
                redisConnection.exec();
                return null;
            }
        }));
    }

    /**
     * 测试RedisTemplate的事务
     */
    @Test
    public void testRedisTransaction(){
        redisUtils.testExecuteTransactionWithRedisCallback();
    }


    @Test
    public void testSessionCallback(){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                return null;
            }
        });
    }

}
