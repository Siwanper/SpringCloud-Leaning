package com.swp.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.concurrent.TimeUnit;

/**
 * 描述: 服务认证中心配置
 *
 * @outhor ios
 * @create 2019-09-11 4:59 PM
 */
@EnableAuthorizationServer
@Configuration
public class oauthServerConfig extends AuthorizationServerConfigurerAdapter{

    /**
     * 密码模式需要设置AuthenticationManager
     * 否则会报错：Unsupported grant type: password
     */
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    /**
     * 客户端配置 用于定义客户详细信息服务的配置器
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 客户端的信息保存在内存中，也可以保存在数据中。
                .withClient("client1") // 客户端ID
                .secret(new BCryptPasswordEncoder().encode("123456")) // 客户端密码
                .authorizedGrantTypes("authorization_code", "refresh_token") // 允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("All")  // 定客户端申请的权限范围 read,write,trust
                .autoApprove(false) // 是否自动授权
                .redirectUris("http://localhost:8086/login") // 验证的回调地址
                .accessTokenValiditySeconds(60 * 60 * 12) // token 有效期
                .refreshTokenValiditySeconds(60 * 60 * 30 *24) // refresh_token 有效期
                .authorities("ADMIN_USER") // 客服端的权限
                .and()
                .withClient("client2")
                .secret("$2a$10$QH4tjuirsZ2h4JYLgnB0COG4V./MO376sXxzL6rSmkFOnhwf6xrSW")
                .authorizedGrantTypes("authorization_code", "refresh_token" , "password", "client_credentials")
                .scopes("read")
                .autoApprove(true)
                .redirectUris("http://localhost:8087/login");
    }

    /**
     * 用来配置授权authorization以及令牌token的访问端点和令牌服务token services
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // DefaultTokenService作为OAuth2中操作token(crud)的默认实现
        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(jwtTokenStore());
        tokenServices.setTokenEnhancer(jwtAccessTokenConverter());
        // 客户端信息
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
        endpoints.tokenServices(tokenServices);
        endpoints.authenticationManager(authenticationManager);
    }

    /**
     * 用来配置令牌（token）端点的安全约束。
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    // token生成器，按照设置的签名来生成Token JwtAccessTokenConverter实现了Token增强器TokenEnhancer接口和令牌转换器AccessTokenConverter接口
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("testKey");
        return jwtAccessTokenConverter;
    }

}
