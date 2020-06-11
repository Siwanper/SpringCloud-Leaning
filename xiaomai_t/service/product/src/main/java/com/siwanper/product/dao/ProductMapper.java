package com.siwanper.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siwanper.product.entity.po.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
