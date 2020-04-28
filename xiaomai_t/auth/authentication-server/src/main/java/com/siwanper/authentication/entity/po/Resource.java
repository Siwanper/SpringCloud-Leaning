package com.siwanper.authentication.entity.po;

import com.siwanper.web.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 资源
 *
 * @outhor ios
 * @create 2020-04-28 12:09 PM
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {

    private String code;
    private String type;
    private String name;
    private String url;
    private String method;
    private String description;

}
