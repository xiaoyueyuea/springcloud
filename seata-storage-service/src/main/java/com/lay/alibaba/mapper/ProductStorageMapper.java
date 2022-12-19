package com.lay.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductStorageMapper {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
