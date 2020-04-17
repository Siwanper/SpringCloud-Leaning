package com.siwanper.organization.entity.param;

import com.siwanper.organization.entity.po.Resource;
import com.siwanper.web.entity.param.BaseParam;
import lombok.Data;

/**
 * 描述:
 * 添加查询资源信息，用于service
 *
 * @outhor ios
 * @create 2020-04-17 11:48 AM
 */
@Data
public class ResourceQueryParam extends BaseParam<Resource> {

    private String code;

    private String type;

    private String name;

    private String url;

    private String method;

}
