package com.siwanper.gateway.web.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.siwanper.authentication.service.IAuthService;
import com.siwanper.gateway.web.service.IPermissionService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@ComponentScan(basePackages = "com.siwanper.authentication")
@Slf4j
public class PermissionService implements IPermissionService {

    @Autowired
    private IAuthService authService;

    @Override
    @Cached(name = "gateway_auth::", key = "#authentication+#method+#url", cacheType = CacheType.LOCAL, timeUnit = TimeUnit.SECONDS, expire = 10, localLimit = 10000)
    public boolean hasPermission(String authentication, String url, String method) {
        return authService.hasPermission(authentication,url,method);
    }

    @Override
    public boolean ignoreAuthentication(String url) {
        return authService.ignoreAuthentication(url);
    }

    @Override
    public Jws<Claims> getJwtToken(String jwtToken) {
        return authService.getJwtToken(jwtToken);
    }
}
