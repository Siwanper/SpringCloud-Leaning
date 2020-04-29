package com.siwanper.authentication.provider;

import com.siwanper.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-29 4:06 PM
 */
@Slf4j
@Component
public class AuthenticationProviderFallback implements AuthenticationProvider {

    public Result decide(String authorization, String url, String method) {
        log.error("签权失败 URL ： {}, method : {}", url, method);
        return Result.fail();
    }
}
