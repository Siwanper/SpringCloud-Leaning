package com.siwanper.resttemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestTemplateConfig {

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
