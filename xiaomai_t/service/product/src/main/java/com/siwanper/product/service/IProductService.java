package com.siwanper.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siwanper.product.entity.param.ProductQueryParam;
import com.siwanper.product.entity.po.Product;

public interface IProductService {

    boolean add(Product product);

    boolean delete(String id);

    boolean update(Product product);

    Product get(String id);

    IPage<Product> search(Page page, ProductQueryParam param);

}
