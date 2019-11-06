package com.swp.cloud.client.service;

import com.swp.cloud.common.core.entity.vo.Result;


public interface IAuthService {

    Result auth(String authentication, String url, String method);

    boolean ignorlAuthentication(String url);

    boolean hasPermission(Result result);

    boolean hasPermission(String authentication, String url, String method);

    boolean invalideJwtAccessToken(String authentication);

}
