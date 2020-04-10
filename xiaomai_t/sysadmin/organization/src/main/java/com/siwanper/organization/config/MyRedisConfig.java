package com.siwanper.organization.config;

import com.siwanper.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: Redis 配置
 *
 * @outhor ios
 * @create 2020-04-10 11:00 AM
 */
@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}
