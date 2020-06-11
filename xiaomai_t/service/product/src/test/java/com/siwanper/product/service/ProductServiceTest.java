package com.siwanper.product.service;


import com.siwanper.product.entity.po.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private IProductService productService;

    @Test
    public void get(){
        Product product = productService.get("1");
        System.out.printf(String.valueOf(product));
    }

}
