package com.sedwt.icloud.controller;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 10:06
 * @description : TODO
 */
@Slf4j
@RestController
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/skill")
    public Result secKill(Integer id){

        // 1. 调用商品服务校验库存

        // 2. 扣除库存

        // 3. 调用订单服务创建订单

        // 4. 订单入消息队列

        // 5. 消费消息处理订单调用支付服务

        // 6. 支付时间内是否支付成功

        // 7. 返回结果


        // ----------下面以一个服务里面执行所有逻辑

        // 使用悲观锁解决超卖问题
//        synchronized (this){
//            log.info("线程：{} 调用接口", Thread.currentThread().getName());
//            return productService.kill(id);
//        }

        log.info("线程：{} 调用接口", Thread.currentThread().getName());
//        if (!rateLimiter.tryAcquire(5, TimeUnit.SECONDS)){
//            return Result.fail("秒杀失败");
//        }



        return productService.kill(id);
    }

    /**
     * qps, 每秒允许的实例请求数
     */
//    private final RateLimiter rateLimiter = RateLimiter.create(50);
//    @GetMapping("/limit")
//    public String limit(Integer id){
//        // 第一种方式，没有获取到token令牌的请求会一直等待，直到获取到令牌
//        //log.info("请求等待的时间：{}", rateLimiter.acquire());
//
//        // 等二种方式，设置一个等待时间，如果在等待的时间内处理获取到了token,则处理业务，如果没有，则丢弃
//        if (!rateLimiter.tryAcquire(10, TimeUnit.SECONDS)){
//            System.out.println("failed");
//            return "falied";
//        }
//        System.out.println("success");
//        return "success";
//    }
}
