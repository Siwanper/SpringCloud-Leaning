package com.siwanper.gateway.admin.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:38 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDefinition {

    private String name;
    private Map<String, Object> args;

}
