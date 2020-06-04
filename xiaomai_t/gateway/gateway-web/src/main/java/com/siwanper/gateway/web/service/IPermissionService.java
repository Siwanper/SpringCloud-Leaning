package com.siwanper.gateway.web.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface IPermissionService {

    /**
     * 请求是否有权限
     * @param authentication Bearer token
     * @param url
     * @param method
     * @return
     */
    boolean hasPermission(String authentication, String url, String method);

    /**
     * 判断请求的url是否在忽略范围内
     * @param url
     * @return
     */
    boolean ignoreAuthentication(String url);

    /**
     * 从认证信息中提取token
     * @param jwtToken toke信息 header.payload.signature
     * @return
     */
    Jws<Claims> getJwtToken(String jwtToken);

}
