package com.swp.oauth.config;

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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-26 5:43 PM
 */
@Configuration
@EnableAuthorizationServer
public class OAutherConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }

    /**
     * 这里客户端的secret是123456，存储的是通过BCryptPasswordEncoder 加密后的
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .scopes("read", "write")
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .authorizedGrantTypes("password", "refresh_token")
                .secret("$2a$10$.zN2l7RN3hxBQ5mf9rnITuIVEwaLfb0XR8aXBU0eAbFaBfP7.OD.a")
                .accessTokenValiditySeconds(1800)
                .and()
                .withClient("service-a")
                .secret("$2a$10$.zN2l7RN3hxBQ5mf9rnITuIVEwaLfb0XR8aXBU0eAbFaBfP7.OD.a")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()
                .withClient("service-b")
                .secret("$2a$10$.zN2l7RN3hxBQ5mf9rnITuIVEwaLfb0XR8aXBU0eAbFaBfP7.OD.a")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
        ;
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }
}
