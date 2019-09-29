package com.swp.cloud.authenticationserver.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 2:34 PM
 */
public interface IAuthenticationService {

    /**
     * 请求权限的验证
     * @param request
     * @return
     */
    boolean decide(HttpServletRequest request);

}
