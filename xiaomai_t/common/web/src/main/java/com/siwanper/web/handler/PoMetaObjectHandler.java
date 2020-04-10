package com.siwanper.web.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.siwanper.core.util.UserContextHolder;
import com.siwanper.web.entity.po.BasePo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 描述:
 * Mybatis Po 公共字段自动填充
 *
 * @outhor ios
 * @create 2020-03-27 3:29 PM
 */
@Slf4j
public class PoMetaObjectHandler implements MetaObjectHandler {

    private String getCurrentUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("createdBy", getCurrentUsername(), metaObject);
        this.setInsertFieldValByName("createdTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("updatedBy", getCurrentUsername(), metaObject);
        this.setUpdateFieldValByName("updatedTime", Date.from(ZonedDateTime.now().toInstant()), metaObject);
    }

}
