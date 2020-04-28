package com.siwanper.authentication.service;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationService {

    /**
     * 判断当前用户认证信息是否有访问权限
     * @param request 根据请求的url和method
     * @return true 有权限  false 无权限
     */
    boolean decide(HttpServletRequest request);

}
