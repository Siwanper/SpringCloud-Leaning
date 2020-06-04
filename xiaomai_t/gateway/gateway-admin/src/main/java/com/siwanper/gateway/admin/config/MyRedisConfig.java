package com.siwanper.gateway.admin.config;

import com.siwanper.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:01 PM
 */
@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}
