package com.siwanper.authentication.service.impl;

import com.siwanper.authentication.provider.AuthenticationProvider;
import com.siwanper.authentication.service.IAuthService;
import com.siwanper.core.entity.vo.Result;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-29 4:29 PM
 */
@Slf4j
@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    private String BEARER = "Bearer ";

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    @Value("${gate.ignore.authentication.startwith}")
    private String ignoreUrls;

    @Override
    public Result authentication(String authorization, String url, String method) {
        return authenticationProvider.decide(authorization, url, method);
    }

    @Override
    public boolean ignoreAuthentication(String url) {
        return Stream.of(ignoreUrls.split(",")).anyMatch(ignoreUrl -> url.startsWith(StringUtils.trim(ignoreUrl)));
    }

    @Override
    public boolean hasPermission(Result authResult){
        log.debug("签权结果：{}", authResult.getData());
        return authResult.isSuccess() && (boolean) authResult.getData();
    }

    @Override
    public boolean hasPermission(String authorization, String url, String method) {
        // 判断authorization
        if (StringUtils.isBlank(authorization) || !authorization.startsWith(BEARER)){
            log.error("token is null or token is not start with Bearer ");
            return false;
        }
        // 解析token true标识token无效
        if (invalidTokenAccess(authorization)) {
            return false;
        }
        return hasPermission(authentication(authorization, url, method));
    }

    @Override
    public Jws<Claims> getJwtToken(String jwtToken){
        if (jwtToken.startsWith(BEARER)) {
            jwtToken = StringUtils.substring(jwtToken, BEARER.length());
        }
        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(jwtToken);
    }

    @Override
    public boolean invalidTokenAccess(String authorization){
        boolean invalid = Boolean.TRUE;
        try {
            getJwtToken(authorization);
            invalid = Boolean.FALSE;
        } catch (SignatureException | ExpiredJwtException | MalformedJwtException ex) {
            log.error("user token error : {}", ex.getMessage());
    }
        return invalid;
    }

}
