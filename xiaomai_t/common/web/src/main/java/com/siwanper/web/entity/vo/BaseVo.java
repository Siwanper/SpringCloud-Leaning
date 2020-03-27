package com.siwanper.web.entity.vo;

import com.siwanper.web.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-27 12:04 PM
 */
@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> implements Serializable {
    private String id;
}
