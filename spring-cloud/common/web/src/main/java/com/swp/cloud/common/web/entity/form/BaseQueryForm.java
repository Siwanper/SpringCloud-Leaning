package com.swp.cloud.common.web.entity.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.common.core.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-02 2:12 PM
 */
@ApiModel
@Slf4j
@Data
public class BaseQueryForm<P extends BaseParam> extends BaseForm {

    /**
     * 分页查询参数，当前页数
     */
    private long current;
    /**
     * 分页查新参数，当前页所显示的数据数量
     */
    private long size;

    public P toParam(Class<P> clazz) {
        P p = null;
        try {
            p = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Param New Instance Error");
        }
        BeanUtils.copyProperties(this,p);
        return p;
    }

    /**
     * 用户分页查询的page参数
     * @return
     */
    public Page getPage(){
        return new Page(this.getCurrent(),this.getSize());
    }


}
