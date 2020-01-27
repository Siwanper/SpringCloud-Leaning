package com.swp.cloud.gateway.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-18 4:25 PM
 */
@Configuration
public class DefaultRedisRateLimiter extends RedisRateLimiter {

    Config getDefaultConfig(){
        return super.getConfig().get("defaultFilters");
    }

    public DefaultRedisRateLimiter(ReactiveRedisTemplate<String, String> redisTemplate, RedisScript<List<Long>> script,@Qualifier("defaultValidator") Validator validator) {
        super(redisTemplate, script, validator);
    }

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        if (null == super.getConfig().get(routeId))
            super.getConfig().put(routeId, getDefaultConfig());
        return super.isAllowed(routeId, id);
    }
}
