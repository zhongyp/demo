package com.zhongyp.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

/**
 * @author zhongyp.
 * @date 2019/6/28
 */
public class RedisUtils {

    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    /**
     * 用于测试redisTemplate.execute的事务管理
     */
    public void testExecuteTransactionWithRedisCallback(){
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.listCommands().lPush("123a".getBytes(), "abc".getBytes());
                redisConnection.listCommands().lPush("1234b".getBytes(), "abc3".getBytes());
                int b = 1/0;
                redisConnection.listCommands().lPush("1235c".getBytes(), "abc4".getBytes());
                redisConnection.listCommands().lPush("1236d".getBytes(), "abc5".getBytes());
                return null;
            }
        });
//        throw new RuntimeException();
    }

    public void testExecutePipelineTransactionWithRedisCallback(){
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public <K, V> String execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                ValueOperations valueOperations = redisOperations.opsForValue();
                valueOperations.set("1", "2");
                valueOperations.set("2", "2");
                int b = 1/0;
                valueOperations.set("3", "2");
                return null;
            }

        });
//        throw new RuntimeException();
    }

    public void testExecutePipelineWithConnection(){
        redisTemplate.execute(new RedisCallback() {
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
