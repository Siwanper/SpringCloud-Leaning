package com.swp.cloud.gateway.admin.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:58 PM
 */
@Configuration
@EnableCaching
public class RedisConfig extends com.swp.cloud.common.web.redis.RedisConfig {

}
