package com.siwanper.resttemplate.config;

import com.siwanper.resttemplate.interception.MyInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class RestTemplateConfig {

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private MyInterception myInterception;

    @Bean
    public RestTemplate restTemplate() {
        return builder.additionalInterceptors(myInterception).setConnectTimeout(Duration.ofSeconds(15)).setReadTimeout(Duration.ofSeconds(10)).build();
    }

//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        RestTemplate restTemplate = new RestTemplate(factory);
//        return restTemplate;
//    }
//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);
//        factory.setConnectTimeout(15000);
//        //设置代理
//        //factory.setProxy(null);
//        return factory;
//    }
}
