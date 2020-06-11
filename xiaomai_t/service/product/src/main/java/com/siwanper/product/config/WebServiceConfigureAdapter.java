package com.siwanper.product.config;

import com.siwanper.web.interception.UserInterception;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServiceConfigureAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor userInterception(){
        return new UserInterception();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterception());
    }
}
