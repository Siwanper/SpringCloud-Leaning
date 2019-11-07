package com.swp.cloud.client.service;

import com.swp.cloud.common.core.entity.vo.Result;


public interface IAuthService {

    /**
     * 用户权限校验
     * @param authentication
     * @param url
     * @param method
     * @return
     */
    Result auth(String authentication, String url, String method);

    /**
     * 访问url是否被忽略
     * @param url
     * @return
     */
    boolean ignorlAuthentication(String url);

    /**
     * 是否有权限
     * @param result
     * @return
     */
    boolean hasPermission(Result result);

    /**
     * 授权是否有权限
     * @param authentication
     * @param url
     * @param method
     * @return
     */
    boolean hasPermission(String authentication, String url, String method);

    /**
     * token是否有效
     * @param authentication
     * @return
     */
    boolean invalideJwtAccessToken(String authentication);

}
