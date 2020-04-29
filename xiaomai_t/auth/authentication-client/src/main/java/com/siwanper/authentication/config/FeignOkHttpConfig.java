package com.siwanper.authentication.config;

import feign.Feign;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 描述: Feign 默认是JDK 的 HttpURLConnection，建立链接的
 * 现在切换为OkHttpClient
 *
 * feign.httpclient.enable: false
 * feign.okhttp.enable: true
 *
 * @outhor ios
 * @create 2020-04-29 3:52 PM
 */
@AutoConfigureBefore(FeignAutoConfiguration.class)
@ConditionalOnClass(Feign.class)
@Configuration
public class FeignOkHttpConfig {

    private int FeignOkHttpReadTimeout = 60;
    private int FeignOkHttpConnectTimeout = 60;
    private int FeignOkHttpWriteTimeout = 120;

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(FeignOkHttpReadTimeout, TimeUnit.SECONDS)
                .connectTimeout(FeignOkHttpConnectTimeout, TimeUnit.SECONDS)
                .writeTimeout(FeignOkHttpWriteTimeout, TimeUnit.SECONDS)
                .build();
    }

}
