package com.swp.cloud.common.web.entity.form;

import com.swp.cloud.common.core.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import sun.swing.BeanInfoUtils;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-02 2:11 PM
 */
@ApiModel
@Slf4j
@Data
public class BaseForm<T extends BasePo> {

    /**
     * 用户名
     */
    private String username;

    /**
     * Form转化为Po
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz){
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Po New Instance Error");
        }
        BeanUtils.copyProperties(this,t);
        return t;
    }

}
