package com.siwanper.web.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.siwanper.web.entity.po.BasePo;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-27 12:11 PM
 */
@Data
public class BaseParam<T extends BasePo> {

    private Date createdStartTime;
    private Date createdEndTime;

    public QueryWrapper<T> build(){
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != this.createdStartTime, "created_time", this.createdStartTime)
                .le(null != this.createdEndTime, "created_time", this.createdEndTime);
        return queryWrapper;
    }

}
