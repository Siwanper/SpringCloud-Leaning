package com.swp.cloud.sysadmin.organization.entity.param;

import com.swp.cloud.common.core.entity.param.BaseParam;
import com.swp.cloud.common.web.entity.form.BaseQueryForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 2:33 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleQueryParam extends BaseParam {

    private String code;
    private String name;
    private Date createdTimeStart;
    private Date createdTimeEnd;

}
