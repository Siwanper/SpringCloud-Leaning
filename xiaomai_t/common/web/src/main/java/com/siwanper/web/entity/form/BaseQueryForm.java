package com.siwanper.web.entity.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siwanper.web.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-27 12:16 PM
 */
@ApiModel
@Data
@Slf4j
public class BaseQueryForm<P extends BaseParam> extends BaseForm {

    /**
     * 去要查询的页数
     */
    private long currentPage = 1;

    /**
     * 需要查询的数据大小
     */
    private long currentSize = 10;

    /**
     * 将Form 转为 Param
     * @param clazz
     * @return
     */
    public P toParam(Class<P> clazz){
        P p = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, p);
        return p;
    }

    /**
     * 获取当前也
     * @return
     */
    public Page getPage(){
        Page page = new Page(this.currentPage, this.currentSize);
        return page;
    }

}
