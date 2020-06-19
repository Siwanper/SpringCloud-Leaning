package com.siwanper.resttemplate.interception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MyInterception implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        String url = httpRequest.getURI().getPath();
        String method = httpRequest.getMethod().name();
        log.info("url : {} , method: {}" , url, method);
        return execution.execute(httpRequest,bytes);
    }
}
