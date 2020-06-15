package com.siwanper.product.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.product.config.BusConfig;
import com.siwanper.product.entity.param.ProductQueryParam;
import com.siwanper.product.entity.po.Product;
import com.siwanper.product.event.sender.ProductSender;
import com.siwanper.product.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siwanper.product.dao.ProductMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductSender sender;

    @Transactional
    @Override
    public boolean add(Product product) {
        return this.save(product);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "product_",key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "product_",key = "#product.id")
    public boolean update(Product product) {
        return this.updateById(product);
    }

    @Override
    @Cached(name = "product_",key = "#id", cacheType = CacheType.BOTH)
    public Product get(String id) {
        Product product = this.getById(id);
        sender.sender(BusConfig.ROUTING_KEY, product);
        return product;
    }

    @Override
    public IPage<Product> search(Page page, ProductQueryParam param) {
        QueryWrapper<Product> wrapper = param.build();
        wrapper.eq(StringUtils.isNotBlank(param.getName()), "name", param.getName());
        return this.page(page, wrapper);
    }
}
