package com.swp.cloud.client.provider;

import com.swp.cloud.common.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "authentication-server", fallback = AuthProvider.AuthProviderFallback.class)
public interface AuthProvider {

    @PostMapping("/auth/permission")
    Result auth(@RequestHeader(HttpHeaders.AUTHORIZATION) String authentication, String url, String method);

    @Component
    class AuthProviderFallback implements AuthProvider {
        @Override
        public Result auth(String authentication, String url, String method) {
            return Result.fail();
        }
    }

}
