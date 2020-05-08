package com.siwanper.authorization.oauth2.enhancer;

import com.google.common.collect.Maps;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

/**
 * 描述: JWT 信息加强。添加额外信息。
 *
 * @outhor ios
 * @create 2020-04-22 2:06 PM
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> additionalInfo = Maps.newHashMap();
        additionalInfo.put("organization", oAuth2Authentication.getName());
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        defaultOAuth2AccessToken.setAdditionalInformation(additionalInfo);
        return defaultOAuth2AccessToken;
    }
}
