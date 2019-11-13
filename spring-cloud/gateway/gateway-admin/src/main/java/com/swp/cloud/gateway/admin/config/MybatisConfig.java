package com.swp.cloud.gateway.admin.config;

import com.swp.cloud.common.web.interceptor.AuditInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:58 PM
 */
@Configuration
@ComponentScan(basePackageClasses = AuditInterceptor.class)
public class MybatisConfig {

}
