package com.lay.alibaba.mapper;

import com.lay.springcloud.entity.SaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SaleOrderMapper {

    void createOrder(SaleOrder order);

    void finishOrder(@Param("userId") Long userId, @Param("productId") Long productId);
}
