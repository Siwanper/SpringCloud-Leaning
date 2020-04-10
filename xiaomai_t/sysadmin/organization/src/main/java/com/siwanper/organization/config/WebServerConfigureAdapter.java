package com.siwanper.organization.config;


import com.siwanper.web.interception.UserInterception;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述: WebMvc 配置
 *
 * @outhor ios
 * @create 2020-04-10 11:08 AM
 */
@Configuration
public class WebServerConfigureAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor userInterceptor() {
        return new UserInterception();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor());
    }
}
