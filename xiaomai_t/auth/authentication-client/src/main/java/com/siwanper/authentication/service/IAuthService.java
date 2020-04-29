package com.siwanper.authentication.service;

import com.siwanper.core.entity.vo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface IAuthService {

    /**
     * 调用签权服务，判断用户是否有权限
     *
     * @param authorization
     * @param url
     * @param method
     * @return
     */
    Result authentication(String authorization, String url, String method);

    /**
     * 判断请求的url是否在忽略范围内。
     * 只要url的开头匹配，就返回true
     *
     * @param url
     * @return
     */
    boolean ignoreAuthentication(String url);

    /**
     * 查看签权的结果，true代表有权限
     *
     * @param authResult
     * @return
     */
    boolean hasPermission(Result authResult);

    /**
     * 调用签权服务，判断用户是否有权限
     *
     * @param authorization
     * @param url
     * @param method
     * @return
     */
    boolean hasPermission(String authorization, String url, String method);

    /**
     * 判断是否有效的 authorization
     * @param authorization
     * @return true代表无效， false代表有效
     */
    boolean invalidTokenAccess(String authorization);

    /**
     * 从认证信息中提取token
     * @param jwtToken toke信息 header.payload.signature
     * @return
     */
    Jws<Claims> getJwtToken(String jwtToken);
}
