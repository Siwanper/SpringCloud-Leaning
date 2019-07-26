package com.swp.serviceb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-26 12:18 PM
 */
@Configuration
@EnableWebSecurity
public class ServiceBSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 设置放行的url
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated();
    }
}