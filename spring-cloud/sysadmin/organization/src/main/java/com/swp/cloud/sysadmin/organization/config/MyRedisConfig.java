package com.swp.cloud.sysadmin.organization.config;

import com.swp.cloud.common.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 12:04 PM
 */
@Configuration
// 允许使用注册开发redis
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}
