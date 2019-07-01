package com.zhongyp.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhongyp.
 * @date 2019/6/28
 */
@Configuration
@Component
@PropertySource("redis.properties")
public class RedisConf {


    /**
     *  Redis db 索引
      */
    @Value("${redis_database}")
    private Integer database;

    /**
     * Redis host
     */
    @Value("${redis_addr}")
    private String host;

    /**
     * Redis 密码
     */
    @Value("${redis_auth}")
    private String password;

    /**
     * Redis 端口
     */
    @Value("${redis_port}")
    private Integer port;

    /**
     * Redis 超时时间
     */
    @Value("${redis_timeout}")
    private Integer timeout;

    /**
     * 最大等待时间
     */
    @Value("${redis_max_wait}")
    private Integer maxWait;

    /**
     * Redis 最大活跃数
     */
    @Value("${redis_max_active}")
    private int maxActive;

    /**
     * 最小空闲数
     */
    @Value("${redis_min_idle}")
    private int minIdle;

    /**
     * 最大空闲数
     */
    @Value("${redis_max_idle}")
    private int maxIdle;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(this.maxIdle);
        poolConfig.setMinIdle(this.minIdle);
        poolConfig.setTestOnCreate(true);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMaxWaitMillis(this.maxWait);
        return poolConfig;
    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisPoolConfig config = jedisPoolConfig();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config);
        jedisConnectionFactory.setDatabase(this.database);
        jedisConnectionFactory.setHostName(this.host);
        jedisConnectionFactory.setPassword(this.password);
        jedisConnectionFactory.setPort(this.port);
        jedisConnectionFactory.setTimeout(this.timeout);
        return jedisConnectionFactory;
    }
    /**
     * redis模板，存储关键字是字符串，值是Jdk序列化
     * @param factory
     * @return
     * @Description:
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        //key序列化方式;但是如果方法上有Long等非String类型的话，会报类型转换错误；
        //Long类型不可以会出现异常信息;
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);

        //默认使用JdkSerializationRedisSerializer序列化方式;会出现乱码，改成StringRedisSerializer
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return redisTemplate;
    }

}
