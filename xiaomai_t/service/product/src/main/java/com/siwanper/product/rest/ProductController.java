package com.siwanper.product.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.siwanper.core.entity.vo.Result;
import com.siwanper.product.entity.form.ProductForm;
import com.siwanper.product.entity.form.ProductQueryForm;
import com.siwanper.product.entity.form.ProductUpdateForm;
import com.siwanper.product.entity.param.ProductQueryParam;
import com.siwanper.product.entity.po.Product;
import com.siwanper.product.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api
@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ApiOperation(value = "添加产品")
    @ApiImplicitParam(name = "productForm", value = "添加商品", required = true, paramType = "ProductForm")
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result add(@Valid @RequestBody ProductForm productForm){
        log.info("product : {}", productForm);
        Product product = productForm.toPo(Product.class);
        return Result.success(productService.add(product));
    }

    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(name = "id", value = "删除商品的ID", required = true, dataType = "path", paramType = "string")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id){
        log.info("delete : {}",id);
        return Result.success(productService.delete(id));
    }

    @ApiOperation(value = "更新商品信息")
    @ApiImplicitParams({
                    @ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "path", paramType = "string"),
            @ApiImplicitParam(name = "productUpdateForm", value = "商品信息", required = true, paramType = "ProductUpdateForm")
            })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(String id, @Valid @RequestBody ProductUpdateForm productUpdateForm){
        log.info("update {} : {}", id, productUpdateForm);
        Product product = productUpdateForm.toPo(Product.class);
        product.setId(id);
        return Result.success(productService.update(product));
    }

    @ApiOperation(value = "查找商品")
    @ApiImplicitParam(name = "id", value = "查找商品的ID", required = true, dataType = "path", paramType = "string")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getById(@PathVariable String id){
        log.info("get : {}", id);
        return Result.success(productService.get(id));
    }

    @ApiOperation(value = "搜索产品")
    @ApiImplicitParam(name = "queryForm", value = "搜索商品", required = true, paramType = "ProductQueryForm")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(@RequestBody ProductQueryForm queryForm) {
        log.info("seach : {}", queryForm);
        ProductQueryParam queryParam = queryForm.toParam(ProductQueryParam.class);
        IPage<Product> products = productService.search(queryForm.getPage(), queryParam);
        return Result.success(products);
    }

}
