package com.sedwt.icloud.service.impl;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.mapper.StockMapper;
import com.sedwt.icloud.product.Stock;
import com.sedwt.icloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:42
 * @description : TODO
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 秒杀商品
     *
     * @param id
     * @return
     */
    @Override
    public Result kill(Integer id) {
        try {
            //String s = redisTemplate.opsForValue().get(id + "_key");
            //log.info("redis的key={}", s);
            // 1. 检查库存
            //TODO redis检查库存, 需要考虑库存是否一致性问题
            Stock store = checkStore(id);

            if (store == null) {
                return Result.fail("库存不足，秒杀失败");
            }
            redisTemplate.opsForValue().set(id + "_key", store);

            // 2. 扣减库存
            Integer total = decStore(id, store.getVersion());
            if (total == 0) {
                return Result.fail("秒杀失败");
            }

            Stock store2 = (Stock) redisTemplate.opsForValue().get(id + "_key");
            log.info("获取对应的值={}", store2);


            // 3. 创建订单。将消息 经过路由发送到交换机
            log.info("即将交给mq发送");
            rabbitTemplate.convertAndSend("miaosha-exchange", "miaosha-routing", store);
            return Result.success("秒杀成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("秒杀失败");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Stock checkStore(Integer id) {
        Stock stock = stockMapper.checkStore(id);
        if (stock == null || stock.getCount() == null || stock.getSale() == null) {
            log.error("库存中不存在该商品");
            return null;
        }

        if (stock.getCount() < stock.getSale()) {
            log.error("该商品库存不足");
            return null;
        }

        // 检查库存
        if (stock.getCount().equals(stock.getSale())) {
            log.error("该商品库存不足");
            return null;
        }
        return stock;
    }

    /**
     * 更新库存（扣减库存）
     *
     * @param id
     * @return
     */
    @Override
    public Integer decStore(Integer id, Integer version) {
        return stockMapper.decStore(id, version);
    }

    /**
     * 恢复库存（库存 +1）
     *
     * @param id
     * @return
     */
    @Override
    public Integer creStore(Integer id) {
        return stockMapper.creStore(id);
    }
}
