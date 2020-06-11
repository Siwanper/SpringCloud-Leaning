package com.siwanper.product.entity.form;

import com.siwanper.product.entity.po.Product;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateForm extends BaseForm<Product> {

    @ApiModelProperty(name = "产品名称")
    private String name;

    @ApiModelProperty(name = "产品描述")
    private String description;

    @ApiModelProperty(name = "是否删除")
    private String deleted;

}
