package com.sedwt.icloud.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author : zhang yijun
 * @date : 2021/3/19 9:05
 * @description : TODO
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisLettuceConfig {

    /**
     * 默认情况下的模板只能支持 RedisTemplate<String,String>，只能存入字符串
     * 因此，我们需要自定义RedisTemplate，设置序列化器，这样我们可以很方便的操作实例对象
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置key序列化为string
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value序列化为json
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 设置hash key序列化为string
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 设置hash value序列化为json
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 设置redis连接工厂，在配置文件里面已配置好，SpringBoot2.x版本会自动读取对应的参数
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
