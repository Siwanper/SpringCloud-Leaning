package com.siwanper.web.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-27 11:54 AM
 */
@Data
public class BasePo implements Serializable {

    public static final String DEFAULT_USERNAME = "system";

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
