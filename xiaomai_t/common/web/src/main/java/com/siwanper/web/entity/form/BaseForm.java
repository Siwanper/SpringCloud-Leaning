package com.siwanper.web.entity.form;

import com.siwanper.web.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-27 12:06 PM
 */
@ApiModel
@Data
@Slf4j
public class BaseForm<T extends BasePo> {

    private String username;

    /**
     * Form 转为 Po
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz){
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }

    public T toPo(String id, Class<T> clazz){
        T t = BeanUtils.instantiateClass(clazz);
        t.setId(id);
        BeanUtils.copyProperties(this,t);
        return t;
    }

}
