package com.sedwt.icloud.mapper;

import com.sedwt.icloud.order.StockOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 11:32
 * @description : TODO
 */
@Mapper
public interface OrderMapper {

    void createOrder( StockOrder stockOrder);
}
