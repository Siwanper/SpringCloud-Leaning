package com.swp.cloud.client.service.impl;

import com.swp.cloud.client.provider.AuthProvider;
import com.swp.cloud.client.service.IAuthService;
import com.swp.cloud.common.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-06 5:08 PM
 */
@Service
@Slf4j
public class AuthServiceImpl implements IAuthService {

    /**
     * Authentication 开头以"bearer "
     */
    private static int BEARER_BEGIN_INDEX = 7;

    private String signingKey = "testKey";

    private String ignorlUrls = "/oauth,/open";

    @Autowired
    private AuthProvider authProvider;


    private MacSigner signer;

    @Override
    public Result auth(String authentication, String url, String method) {
        System.out.println("authentication");
        return authProvider.auth(authentication, url, method);
    }

    @Override
    public boolean ignorlAuthentication(String url) {
        return Stream.of(this.ignorlUrls.split(",")).anyMatch(ignorlUrl -> url.startsWith(StringUtils.trim(ignorlUrl)));
    }

    @Override
    public boolean hasPermission(Result result) {
        return result.isSuccess() && (boolean) result.getData();
    }

    @Override
    public boolean hasPermission(String authentication, String url, String method) {
        boolean invalide = invalideJwtAccessToken(authentication);
        if (invalide) {
            return Boolean.FALSE;
        }
        return hasPermission(auth(authentication, url, method));
    }

    @Override
    public boolean invalideJwtAccessToken(String authentication) {
        signer = Optional.ofNullable(signer).orElse(new MacSigner(signingKey));
        //是否无效 true表示无效 false 表示有效
        boolean invalide = true;

        try {
            Jwt jwt = getJwt(authentication);
            jwt.verifySignature(signer);
            invalide = Boolean.valueOf(false);
        } catch (InvalidSignatureException | IllegalArgumentException ex) {
            log.warn("user token has invalide or signatrue error");
        }

        return invalide;
    }

    public Jwt getJwt(String authentication){
        Jwt jwt = JwtHelper.decode(StringUtils.substring(authentication, BEARER_BEGIN_INDEX));
        return jwt;
    }

}
