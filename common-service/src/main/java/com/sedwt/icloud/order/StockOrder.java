package com.sedwt.icloud.order;

import lombok.Data;

import java.util.Date;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:57
 * @description : 库存订单
 */

@Data
public class StockOrder {

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 库存id
     */
    private Integer stockId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;
}
