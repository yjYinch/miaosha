package com.sedwt.icloud.service.impl;

import com.sedwt.icloud.order.StockOrder;
import com.sedwt.icloud.product.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author : zhang yijun
 * @date : 2021/3/17 11:52
 * @description : TODO
 */
@Slf4j
@Service
@RabbitListener(queues = "miaosha-queue")
public class RabbitConsumer {
    private static final String ORDER_SERVICE_NAME = "order-service";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 创建订单
     *
     * @param store
     */
    @RabbitHandler
    public void processOrder(Stock store) {
        //调用订单服务创建订单
        StockOrder stockOrder = new StockOrder();
        stockOrder.setStockId(store.getId());
        stockOrder.setName(store.getName());
        stockOrder.setCreateTime(new Date());
        try {
            log.info("即将发送http请求");
            ResponseEntity<Integer> entity =
                    restTemplate.postForEntity("http://" + ORDER_SERVICE_NAME + "/order/create", stockOrder, Integer.class);
            log.info("发送HTTP请求成功...{}", entity);
        } catch (Exception e) {
            log.error("发送http请求异常...{}", e.getMessage());
        }
    }
}
