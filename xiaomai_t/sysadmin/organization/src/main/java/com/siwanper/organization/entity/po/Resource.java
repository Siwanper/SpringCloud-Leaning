package com.siwanper.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 资源实体
 *
 * @outhor ios
 * @create 2020-04-17 10:33 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "resource")
public class Resource extends BasePo {

    private String code;
    private String type;
    private String name;
    private String url;
    private String method;
    private String description;

}
