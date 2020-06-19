package com.siwanper.resttemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServerConfig implements WebMvcConfigurer {

    /**
     * 设置资源映射路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir");
        System.out.printf("path : " + path);
        registry.addResourceHandler("/resource/**").addResourceLocations("file:"+path+"/doc/");
        // http://localhost:7000/resource/auth.png
    }
}
