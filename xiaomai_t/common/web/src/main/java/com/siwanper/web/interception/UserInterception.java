package com.siwanper.web.interception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.core.util.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 描述:
 * 用户信息拦截器
 *
 * @outhor ios
 * @create 2020-03-27 2:28 PM
 */
@Slf4j
public class UserInterception implements HandlerInterceptor {

    /**
     * 服务间调用token用户信息，格式json
     * {
     *     "user_name":"必须有",
     *     "其他的key":"value"
     * }
     */
    private static final String X_CLIENT_TOKEN_USER = "x_client_token_user";

    /**
     * 服务间调用认证的token
     *
     */
    private static final String X_CLIENT_TOKEN = "x_client_token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从网关获取并验证，如果验证成功则可信任 X_CLIENT_TOKEN_USER 的用户信息
        checkToken(request.getHeader(X_CLIENT_TOKEN));
        String userInfo = StringUtils.defaultIfBlank(request.getHeader(X_CLIENT_TOKEN_USER),"{}");
        UserContextHolder.getInstance().setContext(new ObjectMapper().readValue(userInfo, Map.class));
        return true;
    }

    private void checkToken(String token){
        log.debug("//TODO 校验token:{}", token);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContextHolder.getInstance().clean();
    }
}
