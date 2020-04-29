package com.siwanper.authentication.provider;

import com.siwanper.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "authentication-server", fallback = AuthenticationProviderFallback.class)
public interface AuthenticationProvider {

    /**
     * 调用签权服务，判断用户是否有权限
     *
     * @param authorization 签名 以 Bearer 开头 JWT token
     * @param url 请求链接
     * @param method 请求方法
     * @return
     */
    @RequestMapping(value = "/oauth/decide", method = RequestMethod.POST)
    Result decide(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization, @RequestParam(value = "url") String url, @RequestParam(value = "method") String method);

}
