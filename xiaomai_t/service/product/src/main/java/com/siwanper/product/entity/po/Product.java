package com.siwanper.product.entity.po;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "product")
public class Product extends BasePo {

    private String name;
    private String description;

    @TableLogic
    private String deleted = "N";

}
