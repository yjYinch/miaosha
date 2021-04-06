package com.sedwt.icloud.service;

import com.sedwt.icloud.order.StockOrder;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:30
 * @description : TODO
 */
public interface OrderService {

    /**
     * 创建订单
     * @param stockOrder
     * @return
     */
    StockOrder createOrder(StockOrder stockOrder);
}
