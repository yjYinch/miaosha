package com.sedwt.icloud.service;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.product.Stock;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:31
 * @description : TODO
 */
public interface ProductService {

    /**
     * 秒杀商品
     * @param id
     * @return
     */
    Result kill(Integer id);

    /**
     * 根据商品id查询库存
     * @param id
     * @return
     * @throws Exception
     */
    Stock checkStore(Integer id) throws Exception;

    /**
     * 更新库存（扣减库存）
     * @param id
     * @return
     */
    Integer decStore(Integer id, Integer version);

    /**
     * 恢复库存（库存 +1）
     * @param id
     * @return
     */
    Integer creStore(Integer id);

}
