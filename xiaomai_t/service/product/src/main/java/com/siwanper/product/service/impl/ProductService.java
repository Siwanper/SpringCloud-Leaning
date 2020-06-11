package com.siwanper.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.product.entity.param.ProductQueryParam;
import com.siwanper.product.entity.po.Product;
import com.siwanper.product.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.siwanper.product.dao.ProductMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Transactional
    @Override
    public boolean add(Product product) {
        return this.save(product);
    }

    @Transactional
    @Override
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Transactional
    @Override
    public boolean update(Product product) {
        return this.updateById(product);
    }

    @Override
    public Product get(String id) {
        Product product = this.getById(id);
        return product;
    }

    @Override
    public IPage<Product> search(Page page, ProductQueryParam param) {
        QueryWrapper<Product> wrapper = param.build();
        wrapper.eq(StringUtils.isNotBlank(param.getName()), "name", param.getName());
        return this.page(page, wrapper);
    }
}
