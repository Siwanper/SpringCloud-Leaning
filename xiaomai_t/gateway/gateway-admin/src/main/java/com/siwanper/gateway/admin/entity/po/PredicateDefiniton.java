package com.siwanper.gateway.admin.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:37 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredicateDefiniton {

    private String name;
    private Map<String, Object> args;

}
