package com.siwanper.product.entity.param;

import com.siwanper.product.entity.po.Product;
import com.siwanper.web.entity.param.BaseParam;
import lombok.Data;

@Data
public class ProductQueryParam extends BaseParam<Product> {

    private String name;

}
