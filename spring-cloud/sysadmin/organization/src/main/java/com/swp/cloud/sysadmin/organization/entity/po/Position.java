package com.swp.cloud.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述: 岗位表
 *
 * @outhor ios
 * @create 2019-09-06 10:43 AM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName
public class Position extends BasePo {

    // 岗位名称
    private String name;
    // 岗位描述
    private String description;
    // 是否已删除Y：已删除，N：未删除
    @TableLogic
    private String deleted = "N";

}
