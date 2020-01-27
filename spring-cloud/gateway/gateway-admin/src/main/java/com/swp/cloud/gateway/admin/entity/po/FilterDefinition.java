package com.swp.cloud.gateway.admin.entity.po;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 5:50 PM
 */
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterDefinition {

    private String name;
    private Map<String, String> args = new LinkedHashMap<>();

}
