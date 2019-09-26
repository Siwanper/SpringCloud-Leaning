package com.swp.cloud.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 6:51 PM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("group")
public class Group extends BasePo {

    // 用户组父id
    private long parentId;
    // 用户组名称
    private String name;
    // 描述
    private String description;
    // 是否已删除Y：已删除，N：未删除
    @TableLogic
    private String deleted = "N";

}
