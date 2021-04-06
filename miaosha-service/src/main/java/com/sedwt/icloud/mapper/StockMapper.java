package com.sedwt.icloud.mapper;

import com.sedwt.icloud.product.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:34
 * @description : TODO
 */
@Mapper
public interface StockMapper {

    /**
     * 根据商品id查询库存
     * @param id
     * @return
     */
    Stock checkStore(Integer id);

    /**
     * 更新库存（扣减库存）
     * @param id
     * @return
     */
    Integer decStore(@Param("id") Integer id, @Param("version") Integer version);

    /**
     * 恢复库存（库存 +1）
     * @param id
     * @return
     */
    Integer creStore(Integer id);
}
