package com.swp.cloud.sysadmin.organization.entity.vo;

import com.swp.cloud.common.core.entity.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 2:35 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends BaseVo {

    private Long id = 0L;
    private String name;
    private String mobile;
    private String username;
    private String description;
    private String deleted;
    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

}
