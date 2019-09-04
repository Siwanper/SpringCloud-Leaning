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
 * @create 2019-09-04 2:38 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryParam extends BaseParam {

    private String name;
    private String mobile;
    private String username;
    private Date createdTimeStart;
    private Date createdTimeEnd;

}
