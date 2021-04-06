package com.sedwt.icloud.service.impl;

import com.sedwt.icloud.mapper.OrderMapper;
import com.sedwt.icloud.order.StockOrder;
import com.sedwt.icloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 13:54
 * @description : TODO
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    /**
     * 创建订单
     *
     * @param stockOrder
     */
    @Override
    public StockOrder createOrder(StockOrder stockOrder) {
        orderMapper.createOrder(stockOrder);

        // 如果创建订单失败
        if (stockOrder.getId() == null){
            // 恢复库存
            return null;
        }
        return stockOrder;
    }
}
