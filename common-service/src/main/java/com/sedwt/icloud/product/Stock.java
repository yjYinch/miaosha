package com.sedwt.icloud.product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:32
 * @description : 商品秒杀库存实体类
 */

@Setter
@Getter
@ToString
public class Stock implements Serializable{

    /**
     * 商品库存id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 秒杀商品总数
     */
    private Integer count;

    /**
     * 已抢购数量
     */
    private Integer sale;

    /**
     * 版本号，乐观锁使用
     */
    private Integer version;
}
