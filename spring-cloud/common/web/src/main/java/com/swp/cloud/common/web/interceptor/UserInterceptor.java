package com.swp.cloud.common.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.common.core.util.UserContextHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 描述: 用户信息拦截器
 *
 * @outhor ios
 * @create 2019-09-02 5:34 PM
 */

public class UserInterceptor implements HandlerInterceptor {

    /**
     * 服务间调用的Token用户信息，json格式
     * {
     *     "username":"必须有",
     *     "自定义的key":"value
     * }
     */
    public static final String X_CLIENT_TOKEN_USER = "x_client_token_user";

    /**
     * 服务间调用的token认证
     */
    public static final String X_CLIENT_TOKEN = "x_client_token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        checkToken(request.getHeader(X_CLIENT_TOKEN));
        String userInfo = StringUtils.defaultIfBlank(request.getHeader(X_CLIENT_TOKEN_USER), "{}");
        UserContextHolder.getInstance().setContext(new ObjectMapper().readValue(userInfo, Map.class));
        return true;
    }

    private void checkToken(String token) {
        // TODO 验证token
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContextHolder.getInstance().clear();
    }
}
