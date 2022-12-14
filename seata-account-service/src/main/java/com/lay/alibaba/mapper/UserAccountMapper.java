package com.lay.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserAccountMapper {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
