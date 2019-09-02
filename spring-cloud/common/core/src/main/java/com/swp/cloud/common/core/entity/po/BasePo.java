package com.swp.cloud.common.core.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 描述:
 * 持久化对象基类
 *
 * @outhor ios
 * @create 2019-09-02 11:47 AM
 */
@Data
public class BasePo implements Serializable {

    public static final String DEFAULT_USERNAME = "system";
    private Long id = 0l;
    private String createdBy = DEFAULT_USERNAME;
    private String updatedBy = DEFAULT_USERNAME;
    private Date createdTime = Date.from(ZonedDateTime.now().toInstant());
    private Date updatedTime = Date.from(ZonedDateTime.now().toInstant());

}
