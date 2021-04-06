package com.sedwt.icloud.controller;

import com.sedwt.icloud.order.StockOrder;
import com.sedwt.icloud.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhang yijun
 * @date : 2021/3/17 13:45
 * @description : TODO
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private static final String PAYMENT_URL = "http://payment-service/payment/pay";

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Integer createOrder(@RequestBody StockOrder stockOrder) {
        logger.info("调用order-service服务，端口号：9002，信息：{}", stockOrder);
        StockOrder order = orderService.createOrder(stockOrder);
        if (order == null){
            return -1;
        }
        // 调用支付服务
        //restTemplate.postForEntity(PAYMENT_URL, stockOrder, String.class);
        return order.getId();
    }
}
