package com.zhongyp.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.DefaultRedisList;
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

    @Test
    public void testSetAndGet(){
        redisTemplate.opsForValue().set("abctest","testabc");
        System.out.println(redisTemplate.opsForValue().get("abctest"));
    }

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

    @Test
    public void testPipline(){
        System.out.println(redisTemplate.executePipelined(new RedisCallback <Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.multi();
                redisConnection.listCommands().lPush("123a".getBytes(), "abc".getBytes());
                redisConnection.listCommands().lPush("1234b".getBytes(), "abc3".getBytes());
                int b = 1/0;
                redisConnection.listCommands().lPush("1235c".getBytes(), "abc4".getBytes());
                redisConnection.listCommands().lPush("1236d".getBytes(), "abc5".getBytes());
                redisConnection.exec();
                return null;
            }
        }));
    }

    @Test
    public void pipeline(){
        List<Object> results = redisTemplate.executePipelined(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.multi();
                for(int i=0; i< 10; i++) {
                    connection.listCommands().lPush("testlist".getBytes(), ("abc" + i).getBytes());
                }
                connection.exec();
                return null;
            }
        });
        results.stream().forEach(System.out::println);
    }

    @Test
    public void testExecutePiplinedTransaction(){
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForSet().add("key", "value1");
                // This will contain the results of all ops in the transaction
                return operations.exec();
            }

        });
    }
    @Test
    public void testExecuteTransaction(){
        redisTemplate.execute(new SessionCallback<Object>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForList().leftPush("123a".getBytes(), "abc".getBytes());
                operations.opsForList().leftPush("1234b".getBytes(), "abc3".getBytes());
                int b = 1/0;
                operations.opsForList().leftPush("1235c".getBytes(), "abc4".getBytes());
                operations.opsForList().leftPush("1236d".getBytes(), "abc5".getBytes());
                return operations.exec();
            }

        });
    }
    @Test
    public void testExecuteTransactionWithRedisCallback(){
        redisTemplate.execute(new RedisCallback <Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.multi();
                redisConnection.listCommands().lPush("123a".getBytes(), "abc".getBytes());
                redisConnection.listCommands().lPush("1234b".getBytes(), "abc3".getBytes());
                int b = 1/0;
                redisConnection.listCommands().lPush("1235c".getBytes(), "abc4".getBytes());
                redisConnection.listCommands().lPush("1236d".getBytes(), "abc5".getBytes());
                redisConnection.exec();
                return null;
            }
        });
    }
}
