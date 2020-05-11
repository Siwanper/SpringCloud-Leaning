package com.siwanper.gateway.admin.config;

import com.siwanper.web.interception.UserInterception;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:05 PM
 */
@Configuration
public class WebServerMvcConfigureAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor interceptor(){
        return new UserInterception();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor());
    }
}
