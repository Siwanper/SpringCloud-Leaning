package com.swp.cloud.sysadmin.organization.entity.param;

import com.swp.cloud.common.core.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 4:37 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceQueryParam extends BaseParam{

    private String name;
    private String code;
    private String type;
    private String url;
    private String method;
    private Date createdTimeStart;
    private Date createdTimeEnd;

}
