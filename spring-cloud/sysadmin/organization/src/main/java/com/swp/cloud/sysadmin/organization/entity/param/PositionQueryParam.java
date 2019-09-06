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
 * @create 2019-09-06 2:11 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionQueryParam extends BaseParam {

    // 岗位名称
    private String name;
    private Date createdTimeStart;
    private Date createdTimeEnd;

}
