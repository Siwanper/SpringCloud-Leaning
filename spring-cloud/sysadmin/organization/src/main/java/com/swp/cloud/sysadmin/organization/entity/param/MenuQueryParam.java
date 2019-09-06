package com.swp.cloud.sysadmin.organization.entity.param;

import com.swp.cloud.common.core.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述: 菜单
 *
 * @outhor ios
 * @create 2019-09-06 2:43 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuQueryParam extends BaseParam {

    // 菜单名称
    private String name;
    private Date createdTimeStart;
    private Date createdTimeEnd;

}
