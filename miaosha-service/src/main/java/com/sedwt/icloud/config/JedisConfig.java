//package com.sedwt.icloud.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * @author : zhang yijun
// * @date : 2021/3/18 17:14
// * @description : TODO
// */
//
//@Configuration
//public class JedisConfig {
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private Integer port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private Integer maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private Integer minIdle;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private Integer maxActive;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private Integer maxWait;
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//        // 使用Standalone模式配置环境，SpringBoot2.0版本之后推荐使用Standalone、Sentinel、RedisCluster模式之一配置环境类
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(host);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(password);
//
//        // 由于JedisConnectionFactory没有提供redisStandaloneConfiguration和jedisConfig的构造方法，需要自己构造
//        // 获得默认的连接池构造器
//
//        // 构造jedis客户端配置
//        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration
//                .builder()
//                .usePooling()
//                .poolConfig(jedisPoolConfig)
//                .build();
//        // 单机配置 + 客户端配置 = jedis连接工厂
//        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
//    }
//
//    @Bean
//    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        return new StringRedisTemplate(redisConnectionFactory);
//    }
//
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMinIdle(minIdle);
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMaxWaitMillis(maxWait);
//        return jedisPoolConfig;
//    }
//}
